package net.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;


public class TalkServer {

	Vector<ClientThread> vc;	// 클라이언트 스레드를 담는 객체
	ServerSocket server;
	int port = 8005;
	TalkMgr mgr;
	
	/* 생성자 */
	public TalkServer() {
		try {
			vc = new Vector<ClientThread>();
			server = new ServerSocket(port);
			mgr = new TalkMgr();
		} 
		catch (Exception e) {
			System.err.println("Error in Server");
			e.printStackTrace();
			System.exit(1); // 비정상적인 종료. 현재로서는 1은 의미없는 값이다.
		}
		System.out.println("*******************************************");
		System.out.println("************* Talk Server 1.0 *************");
		System.out.println("** 클라이언트 접속을 기다리고 있습니다.  **");
		System.out.println("*******************************************");
		
		try {
			while (true) {
				Socket sock = server.accept();
				ClientThread ct = new ClientThread(sock);
				ct.start();	// 쓰레드 스케줄러에게 이 쓰레드 객체를 등록.
				vc.add(ct);	//Client 접속 후에 생성된 객체(ClientThread)를 Vector에 저장
			}
		} 
		catch (Exception e) {
			System.err.println("Error in Socket");
			e.printStackTrace();
		}
	}
	
	public void sendAllMessage(String msg) {
		for (int i=0; i<vc.size(); i++) {
			ClientThread ct = vc.get(i); // vector에서 ct를 하나씩 가져옴.
			ct.sendMessage(msg);		// ct에 연결된 Client에게 메세지 전송 
		}
	}
	
	public void removeClient(ClientThread ct) {
		vc.remove(ct);
	}
	
	/* 접속된 모든 id 리스트 리턴 */
	public String getIds() {	// ClientThread에 저장된 id를 가져와서 String type으로 리턴
		String ids = "";
		for (int i=0; i<vc.size(); i++) {
			ClientThread ct = vc.get(i);
			ids += ct.id+ ";";
		}
		return ids;				// ex) aaa;bbb;ccc;ddd;홍길동;
	}
	
	/* 매개변수 id값으로 ClientThread3를 검색 */
	public ClientThread findClient(String id) {
		ClientThread ct = null;
		for (int i=0; i<vc.size(); i++) {
			ct = vc.get(i);
			if (ct.id.equals(id)) {	// 매개변수 id와 Client의 id가 같다면,
				break;
			}
		}
		return ct;
	}
	
	/* 내부 클래스 */
	class ClientThread extends Thread {
		
		Socket sock;
		BufferedReader in;
		PrintWriter out;
		String id = "";
		
		public ClientThread(Socket sock) {
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
				System.err.println(sock+ "[" +id+ "] 끊어짐!!!");
				//e.printStackTrace();	// test - 에러코드 출력
			}
		}
		
		/**
		 * run 되는 동안 반복적으로(루틴) 실행되는 메소드.
		 * 로그인 화면과 클라이언트 채팅창에서 line을 읽어들이고,
		 * Protocol에 따라 메시지를 송출한다.
		 * @param line 로그인창, 클라이언트 채팅창에서 out된 문자열
		 */
		public void routine(String line) {
			System.out.println("line : " +line);	// 넘어온 line 내용 확인
			int idx  = line.indexOf(':');			// 분리 기준 ':'
			String cmd = line.substring(0, idx);	// 앞쪽 문자열
			String data = line.substring(idx+1);	// 뒤쪽 문자열
			
			// 로그인 시 ID:aaa;1234 이렇게 날아온다.
			if (cmd.equals(TalkProtocol.ID)) {		// 앞쪽 문자열이 ID 이면,
				//System.out.println("ID 분리 aaa;1234 -> 'ID' 인식");	// test - ID 와 aaa;1234 분리 테스트 출력
				idx = data.indexOf(";");		// 문자 ; 기준으로 분리
				cmd = data.substring(0, idx);	// 아이디
				data = data.substring(idx+1);	// 비밀번호
				//System.out.println(cmd+ " -분리 테스트- " +data);	// test - 아이디와 비밀번호 분리 테스트 출력
				
				if (mgr.loginChk(cmd, data)) {	// TalkMgr의 로그인 과정(DB 확인)이 성공하면
					// 이중 접속인지 확인하는 과정
					ClientThread ct = findClient(cmd);	// 스레드에 현재 접속시도하는 아이디가 있는지 찾는다.
					if (ct!=null && ct.id.equals(cmd)) {
						// 이중 접속
						sendMessage(TalkProtocol.ID+ ":" + "C");
					}
					else {	// 이중접속이 아니면
						id = cmd;
						sendMessage(TalkProtocol.ID+ ":" + "T");
						sendAllMessage(TalkProtocol.CHATALL+ ":" + "[" +id+ "]님이 입장하였습니다.");
					}
				}
				else {	// 로그인 실패
					sendMessage(TalkProtocol.ID+ ":" + "F");
				}
			}
			else if (cmd.equals(TalkProtocol.CHATALL)) {	// 앞쪽 문자열이 CHATALL이면, (단체톡)
				sendAllMessage(TalkProtocol.CHATALL+ ":[" +id+ "]" +data);
			}
		}
		
		public void sendMessage(String msg) {
			out.println(msg);
		}
	}
	
	public static void main(String[] args) {
		new TalkServer();
	}

}
