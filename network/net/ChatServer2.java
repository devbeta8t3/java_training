package net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;


public class ChatServer2 {

	Vector<ClientThread2> vc;	// 클라이언트 스레드를 담는 객체
	ServerSocket server;
	int port = 8002;
	
	/* 생성자 */
	public ChatServer2() {
		try {
			vc = new Vector<ClientThread2>();
			server = new ServerSocket(port);
		} 
		catch (Exception e) {
			System.err.println("Error in Server");
			e.printStackTrace();
			System.exit(1); // 비정상적인 종료. 현재로서는 1은 의미없는 값이다. (던지는 값?)
		}
		System.out.println("************* Chat Server 2.0 *************");
		System.out.println("** 클라이언트 접속을 기다리고 있습니다.  **");
		System.out.println("*******************************************");
		
		try {
			while (true) {
				Socket sock = server.accept();
				ClientThread2 ct = new ClientThread2(sock);
				ct.start();	// 쓰레드 스케줄러에게 이 쓰레드 객체 시작할 준비를 등록. 개발자가 쓰레드를 직접 run() 호출 불가.
				//Client 접속 후에 생성된 객체(ClientThread2)를 Vector에 저장
				vc.addElement(ct);
			}
		} 
		catch (Exception e) {
			System.err.println("Error in Socket");
			e.printStackTrace();
		}
	}
	
	public void sendAllMessage(String msg) {
		for (int i=0; i<vc.size(); i++) {
			ClientThread2 ct = vc.get(i); // vector에서 ct를 하나씩 가져옴. get과 elementAt 같다. 아무거나 쓰세요.
			ct.sendMessage(msg);		// ct에 연결된 Client에게 메세지 전송 
		}
	}
	
	public void removeClient(ClientThread2 ct) {
		vc.remove(ct);
	}
	
	/* 접속된 모든 id 리스트 리턴 */
	public String getIds() {	// ClientThread2에 저장된 id를 가져와서 String type으로 리턴
		String ids = "";
		for (int i=0; i<vc.size(); i++) {
			ClientThread2 ct = vc.get(i);
			ids += ct.id+ ";";
		}
		return ids;				// ex) aaa;bbb;ccc;ddd;홍길동;
	}
	
	/* 매개변수 id값으로 ClientThread2를 검색 */
	public ClientThread2 findClient(String id) {
		ClientThread2 ct = null;
		for (int i=0; i<vc.size(); i++) {
			ct = vc.get(i);
			if (ct.id.equals(id)) {	// 매개변수 id와 Client의 id가 같다면,
				break;
			}//--if
		}//--for
		return ct;
	}//--findClient 메소드
	
	/* 내부 클래스 */
	class ClientThread2 extends Thread {
		
		Socket sock;
		BufferedReader in;
		PrintWriter out;
		String id;
		
		public ClientThread2(Socket sock) {
			try {
				this.sock = sock;			// 관문을 만들었다.
				in = new BufferedReader(
						new InputStreamReader(sock.getInputStream()));	// 들어오는 빨대 꽂았다.
				out = new PrintWriter(sock.getOutputStream(), true);	// 나가는 빨대 꽂았다.
				System.out.println(sock+ " 접속됨...");	// sock => sock.toString() 호출
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			try {
				out.println("*** 사용하실 아이디를 입력하세요.");
				while (true) {
					String line = in.readLine();
					if (line==null)
						break;
					else
						routine(line);
				}
			} 
			catch (Exception e) {
				removeClient(this);
				System.err.println(sock+ "[" +id+ "] 끊어짐...!!!");
			}
		}
		
		public void routine(String line) {
			System.out.println("line : " +line);
			//CHATALL:오늘은 목요일입니다.
			int idx  = line.indexOf(':');			// 분리
			String cmd = line.substring(0, idx);	// CHATALL
			String data = line.substring(idx+1);	// 오늘은...
			
			if (cmd.equals(ChatProtocol2.ID)) {		// ID:aaa
				id = data;
				// 새로운 접속자가 추가되었기 때문에 리스트 재전송 (대화자 명단 갱신)
				sendAllMessage(ChatProtocol2.CHATLIST+ ":" +getIds());
				// 모든 접속자에게 welcome 메시지 전송
				sendAllMessage(ChatProtocol2.CHATALL+ ":" + "[" +id+ "]님이 입장하였습니다.");
			}
			else if (cmd.equals(ChatProtocol2.CHAT)) {	// CHAT:bbb;밥먹자
				idx  = line.indexOf(';');			// 분리
				cmd /* bbb */ = data.substring(0, idx);
				data /* 밥먹자 */= data.substring(idx+1);
				// id:bbb 찾아야함.
				ClientThread2 ct = findClient(cmd);
				if (ct != null) {
					//bbb(받는 사람) 창에 메세지
					ct.sendMessage(ChatProtocol2.CHAT+ ":[" +id+ "(S)]" +data);
					//aaa(보내는 사람, 내자신) 창에 메시지
					sendMessage(ChatProtocol2.CHAT+ ":[" +id+ "(S)]" +data);
				}
				else {
					//aaa(보내는 사람, 내자신) 창에 메시지
					sendMessage(ChatProtocol2.CHAT+ ":[" +cmd+ "]님은 접속자가 아닙니다.");
				}
			}
			else if (cmd.equals(ChatProtocol2.CHATALL)) {
				sendAllMessage(ChatProtocol2.CHATALL+ ":[" +id+ "]" +data);
			}
			else if (cmd.equals(ChatProtocol2.MESSAGE)) {
				idx  = line.indexOf(';');			// 분리
				cmd  = data.substring(0, idx);
				data = data.substring(idx+1);
				ClientThread2 ct = findClient(cmd);
				if (ct != null) {
					ct.sendMessage(ChatProtocol2.MESSAGE+ ":" +id+ ";" +data);
				}
				else {
					sendMessage(ChatProtocol2.CHAT+ ":[" +cmd+ "]님은 접속자가 아닙니다.");
				}
			}
			
		}
		
		public void sendMessage(String msg) {
			out.println(msg);
		}
	}
	
	public static void main(String[] args) {
		new ChatServer2();
//		String str = "CHATALL:오늘은 목요일입니다.";
//		int idx = str.indexOf(':');
//		String cmd = str.substring(0, idx);
//		String data = str.substring(idx+1);
//		System.out.println(cmd);
//		System.out.println(data);
	}

}
