package net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//Thread, 내부클래스
public class EchoServer {

	public EchoServer() {
		//java.io, java.net, java.sql 거의 모든 메소드 예외 가능성
		try {
			int port = 8000;
			int cnt = 0;//Client 접속개수
			ServerSocket server = new ServerSocket(port);
			System.out.println("ServerSocket Start.........");
			while(true) {
				//Client가 접속 할때까지 대기 상태
				Socket sock = server.accept();
				EchoThread et = new EchoThread(sock);
				et.start();//run 메소드 호출
				cnt++;
				System.out.println("Client " + cnt + " Socket");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	class EchoThread extends Thread{
		
		Socket sock;
		BufferedReader in;
		PrintWriter out;
		
		public EchoThread(Socket sock) {
			try {
				this.sock = sock;
				in = new BufferedReader(
						new InputStreamReader(sock.getInputStream()));
				out = new PrintWriter(sock.getOutputStream(), true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//--생성자
		
		public void run() {
			try {
				//Client가 접속하면 처음으로 받는 메세지
				out.println("Hello Enter BYE to exit");
				while(true) {
					//Client가 메세지 보낼때 까지 대기
					String line = in.readLine();
					if(line==null) {
						break;//Client가 접속을 끊을때
					}else {
						out.println("Echo : " + line);
						if(line.equals("BYE"))
							break;
					}
				}//--while
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//--run
		
	}//--class
	
	public static void main(String[] args) {
		new EchoServer();
	}
}









