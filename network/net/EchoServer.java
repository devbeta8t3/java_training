package net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//Thread, 내부클래스
public class EchoServer {

	
	public EchoServer() {
		//java.io, java.net, java.sql : 거의 모든 메소드가 예외 가능성 있음. 따라서 try-catch
		try {
			int port = 8000;	// Port 번호
			int cnt = 0;		// Client 접속 개수
			ServerSocket server = new ServerSocket(port);
			
			System.out.println("ServerSocket Start..........");
			
			while (true) {
				//Client가 접속할 때까지 대기 상태
				Socket sock = server.accept();	// 대기하다가 클라이언트가 접속하면 소켓 객체가 만들어진다.
				EchoThread et = new EchoThread(sock); // 생성된 소켓에 스레드를 만든다.
				et.start();	//run 메소드 호출 (엄밀히 말하면... 실행 등록)
				
				cnt++;
				System.out.println("Client " +cnt+ " Socket");
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	class EchoThread extends Thread {
		Socket sock;
		BufferedReader in;
		PrintWriter out;
		
		public EchoThread(Socket sock) {
			try {
				this.sock = sock;			// 관문을 만들었다.
				in = new BufferedReader(
						new InputStreamReader(sock.getInputStream()));	// 들어오는 빨대 꽂았다.
				out = new PrintWriter(sock.getOutputStream(), true);	// 나가는 빨대 꽂았다.
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		} //--생성자
		
		@Override
		public void run() {
			try {
				//Client가 접속하면 처음으로 받는 메시지
				out.println("Hello Enter BYE to exit");	// 반드시 println 써야한다. 엔터 역할.
				while (true) {
					//Client가 메시지 보낼 때까지 대기
					String line = in.readLine();
					if (line==null) {	// Client가 접속을 끊을때 break;
						break;
					}
					else {
						out.println("Echo : " +line);
						if (line.equals("BYE"))	// Client가 BYE를 치면 break;
							break;
					}
				}//--while
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		} //--run 메소드
		
	} //--class EchoThread
	
	public static void main(String[] args) {
		new EchoServer();
	}

}
