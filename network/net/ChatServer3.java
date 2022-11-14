package net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;


public class ChatServer3 {

	Vector<ClientThread3> vc;	// 클라이언트 스레드를 담는 객체
	ServerSocket server;
	int port = 8003;
	ChatMgr3 mgr;
	MsgMgr3 mgr2;
	
	/* 생성자 */
	public ChatServer3() {
		try {
			vc = new Vector<ClientThread3>();
			server = new ServerSocket(port);
			mgr = new ChatMgr3();
			mgr2 = new MsgMgr3();
		} 
		catch (Exception e) {
			System.err.println("Error in Server");
			e.printStackTrace();
			System.exit(1); // 비정상적인 종료. 현재로서는 1은 의미없는 값이다. (던지는 값?)
		}
		System.out.println("*******************************************");
		System.out.println("************* Chat Server 3.0 *************");
		System.out.println("** 클라이언트 접속을 기다리고 있습니다.  **");
		System.out.println("*******************************************");
		
		try {
			while (true) {
				Socket sock = server.accept();
				ClientThread3 ct = new ClientThread3(sock);
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
			ClientThread3 ct = vc.get(i); // vector에서 ct를 하나씩 가져옴. get과 elementAt 같다. 아무거나 쓰세요.
			ct.sendMessage(msg);		// ct에 연결된 Client에게 메세지 전송 
		}
	}
	
	public void removeClient(ClientThread3 ct) {
		vc.remove(ct);
	}
	
	/* 접속된 모든 id 리스트 리턴 */
	public String getIds() {	// ClientThread2에 저장된 id를 가져와서 String type으로 리턴
		String ids = "";
		for (int i=0; i<vc.size(); i++) {
			ClientThread3 ct = vc.get(i);
			ids += ct.id+ ";";
		}
		return ids;				// ex) aaa;bbb;ccc;ddd;홍길동;
	}
	
	/* 매개변수 id값으로 ClientThread3를 검색 */
	public ClientThread3 findClient(String id) {
		ClientThread3 ct = null;
		for (int i=0; i<vc.size(); i++) {
			ct = vc.get(i);
			if (ct.id.equals(id)) {	// 매개변수 id와 Client의 id가 같다면,
				break;
			}//--if
		}//--for
		return ct;
	}//--findClient 메소드
	
	/* 내부 클래스 */
	class ClientThread3 extends Thread {
		
		Socket sock;
		BufferedReader in;
		PrintWriter out;
		String id = "";
		
		public ClientThread3(Socket sock) {
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
				//e.printStackTrace();	// test - 에러코드 출력
			}
		}
		
		public void routine(String line) {
			System.out.println("line : " +line);	// ID:aaa;1234
			int idx  = line.indexOf(':');			// 분리 기준 ':'
			String cmd = line.substring(0, idx);	// ID
			String data = line.substring(idx+1);	// aaa;1234
			
			// ID:aaa;1234 이렇게 날아옵니다.
			if (cmd.equals(ChatProtocol3.ID)) {		// ID:aaa
				System.out.println("ID 분리 aaa;1234 -> 'ID' 인식");	// test - ID 와 aaa;1234 분리 테스트 출력
				idx = data.indexOf(";");		// 문자 ; 기준으로 분리
				cmd = data.substring(0, idx);	// aaa를 가진다.
				data = data.substring(idx+1);	// 1234를 가진다.
				System.out.println(cmd+ " -분리 테스트- " +data);	// test - id와 password 분리 테스트 출력
				
				if (mgr.loginChk(cmd, data)) {	// 로그인 성공
					// 이중 접속인지 확인하는 과정
					ClientThread3 ct = findClient(cmd);	// aaa
					if (ct!=null && ct.id.equals(cmd)) {
						// 이중 접속
						sendMessage(ChatProtocol3.ID+ ":" + "C");
					}
					else {
						id = cmd;
						sendMessage(ChatProtocol3.ID+ ":" + "T");
						sendAllMessage(ChatProtocol3.CHATLIST+ ":" +getIds());
						sendAllMessage(ChatProtocol3.CHATALL+ ":" + "[" +id+ "]님이 입장하였습니다.");
					}
				}
				else {	// 로그인 실패
					sendMessage(ChatProtocol3.ID+ ":" + "F");
				}
			}
			else if (cmd.equals(ChatProtocol3.CHAT)) {	// CHAT 일때 data는 bbb;밥묵자 
				idx  = data.indexOf(';');			// 분리
				cmd /* bbb */ = data.substring(0, idx);
				data /* 밥묵자 */= data.substring(idx+1);
				// id:bbb 찾아야함.
				ClientThread3 ct = findClient(cmd);
				if (ct != null) {
					//bbb(받는 사람) 창에 메세지
					ct.sendMessage(ChatProtocol3.CHAT+ ":[" +id+ "(S)]" +data);
					//aaa(보내는 사람, 내자신) 창에 메시지
					sendMessage(ChatProtocol3.CHAT+ ":[" +id+ "(S)]" +data);
				}
				else {
					//aaa(보내는 사람, 내자신) 창에 메시지
					sendMessage(ChatProtocol3.CHAT+ ":[" +cmd+ "]님은 접속자가 아닙니다.");
				}
			}
			else if (cmd.equals(ChatProtocol3.CHATALL)) {
				sendAllMessage(ChatProtocol3.CHATALL+ ":[" +id+ "]" +data);
			}
			else if (cmd.equals(ChatProtocol3.MESSAGE)) {
				idx  = data.indexOf(';');			// 분리
				cmd  = data.substring(0, idx);
				data = data.substring(idx+1);
				ClientThread3 ct = findClient(cmd);
				
				if (ct != null) {
					MessageBean3 bean = new MessageBean3();
					bean.setFId(id);	// aaa
					bean.setTId(cmd);	// bbb
					bean.setMsg(data);// 밥먹자
					mgr2.insertMsg(bean);
					ct.sendMessage(ChatProtocol3.MESSAGE+ ":" +id+ ";" +data);
				}
				else {
					sendMessage(ChatProtocol3.CHAT+ ":[" +cmd+ "]님은 접속자가 아닙니다.");
				}
			}
			else if (cmd.equals(ChatProtocol3.MSGLIST)) {
				// DB에서 MsgList 리턴 받아 Client로 보냄
				Vector<MessageBean3> vlist = mgr2.getMsgList(id);
				// MSGLIST:aaa,bbb,밥먹자;bbb,ccc,하이;... 이런 형식으로 Client로 보낸다.
				String str = "";
				for (int i=0; i<vlist.size(); i++) {
					MessageBean3 bean = vlist.get(i);
					str += bean.getFId() + ",";
					str += bean.getTId() + ",";
					str += bean.getMsg() + ";";
				}
				sendMessage(ChatProtocol3.MSGLIST+ ":" +str);
			}
			
		}
		
		public void sendMessage(String msg) {
			out.println(msg);
		}
	}
	
	public static void main(String[] args) {
		new ChatServer3();
//		String str = "CHATALL:오늘은 목요일입니다.";
//		int idx = str.indexOf(':');
//		String cmd = str.substring(0, idx);
//		String data = str.substring(idx+1);
//		System.out.println(cmd);
//		System.out.println(data);
	}

}
