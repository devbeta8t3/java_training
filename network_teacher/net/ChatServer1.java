package net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ChatServer1 {
	
	Vector<ClientThread1> vc;
	ServerSocket server;
	int port = 8001;

	public ChatServer1() {
		try {
			vc = new Vector<ClientThread1>();
			server = new ServerSocket(port);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error in Server");
			System.exit(1);//비정상적인 종료
		}
		System.out.println("**********************");
		System.out.println("ChatServer v1.0 시작되었습니다.");
		System.out.println("**********************");
		try {
			while(true) {
				Socket sock = server.accept();
				ClientThread1 ct = new ClientThread1(sock);
				ct.start();//쓰레드 스케줄러에게 이 쓰레드 객체 시작할 준비 등록
				//Client 접속후에 생성된 객체(ClientThread1)를 Vector에 저장
				vc.addElement(ct);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error in Socket");
		}
	}
	
	//전체 접속자에게 메세지 전달 - Vector
	public void sendAllMessage(String msg) {
		//Vector 및 배열은 항상 for문
		for (int i = 0; i < vc.size(); i++) {
			ClientThread1 ct = vc.get(i);//vec에서 ct를 하나씩 가져옴.
			ct.sendMessage(msg);//ct에 연결된 Client에게 메세지 전송
		}//--for
	}//--sendAllMessage
	
	//Vector에서 ClientThread1 제거
	public void removeClient(ClientThread1 ct) {
		vc.remove(ct);
	}
	
	class ClientThread1 extends Thread{
		
		Socket sock;
		BufferedReader in;
		PrintWriter out;
		String id;
		
		public ClientThread1(Socket sock) {
			try {
				this.sock = sock;
				in = new BufferedReader(
						new InputStreamReader(sock.getInputStream()));
				out = new PrintWriter(sock.getOutputStream(), true);
				//sock => sock.toString() 호출
				System.out.println(sock + " 접속됨...");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			try {
				//Client에게 최초 보내지 메세지
				out.println("사용하실 아이디를 입력하세요.");
				//Client 입력한 id를 저장
				id = in.readLine();
				//접속한 모든 Client에게 welcome 메세지 전달
				sendAllMessage("["+id+"]님이 입장하였습니다.");
				String data = "";
				while(true) {
					data = in.readLine();
					if(data==null) 
						break;
					sendAllMessage("["+id+"]"+data);
				}
				in.close();
				out.close();
				sock.close();
			} catch (Exception e) {
				//자신의 객체를 Vector에서 제거
				removeClient(this);
				System.err.println(sock + " 끊어짐...");
				//e.printStackTrace();
			}
		}
		
		//Client에게 메세지 보내는 메소드
		public void sendMessage(String msg) {
			out.println(msg);
		}
	}
	
	public static void main(String[] args) {
		new ChatServer1();
	}
}