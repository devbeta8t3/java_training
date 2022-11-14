package net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//Thread, ����Ŭ����
public class EchoServer {

	public EchoServer() {
		//java.io, java.net, java.sql ���� ��� �޼ҵ� ���� ���ɼ�
		try {
			int port = 8000;
			int cnt = 0;//Client ���Ӱ���
			ServerSocket server = new ServerSocket(port);
			System.out.println("ServerSocket Start.........");
			while(true) {
				//Client�� ���� �Ҷ����� ��� ����
				Socket sock = server.accept();
				EchoThread et = new EchoThread(sock);
				et.start();//run �޼ҵ� ȣ��
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
		}//--������
		
		public void run() {
			try {
				//Client�� �����ϸ� ó������ �޴� �޼���
				out.println("Hello Enter BYE to exit");
				while(true) {
					//Client�� �޼��� ������ ���� ���
					String line = in.readLine();
					if(line==null) {
						break;//Client�� ������ ������
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









