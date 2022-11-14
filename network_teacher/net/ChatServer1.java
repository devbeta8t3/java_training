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
			System.exit(1);//���������� ����
		}
		System.out.println("**********************");
		System.out.println("ChatServer v1.0 ���۵Ǿ����ϴ�.");
		System.out.println("**********************");
		try {
			while(true) {
				Socket sock = server.accept();
				ClientThread1 ct = new ClientThread1(sock);
				ct.start();//������ �����ٷ����� �� ������ ��ü ������ �غ� ���
				//Client �����Ŀ� ������ ��ü(ClientThread1)�� Vector�� ����
				vc.addElement(ct);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error in Socket");
		}
	}
	
	//��ü �����ڿ��� �޼��� ���� - Vector
	public void sendAllMessage(String msg) {
		//Vector �� �迭�� �׻� for��
		for (int i = 0; i < vc.size(); i++) {
			ClientThread1 ct = vc.get(i);//vec���� ct�� �ϳ��� ������.
			ct.sendMessage(msg);//ct�� ����� Client���� �޼��� ����
		}//--for
	}//--sendAllMessage
	
	//Vector���� ClientThread1 ����
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
				//sock => sock.toString() ȣ��
				System.out.println(sock + " ���ӵ�...");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			try {
				//Client���� ���� ������ �޼���
				out.println("����Ͻ� ���̵� �Է��ϼ���.");
				//Client �Է��� id�� ����
				id = in.readLine();
				//������ ��� Client���� welcome �޼��� ����
				sendAllMessage("["+id+"]���� �����Ͽ����ϴ�.");
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
				//�ڽ��� ��ü�� Vector���� ����
				removeClient(this);
				System.err.println(sock + " ������...");
				//e.printStackTrace();
			}
		}
		
		//Client���� �޼��� ������ �޼ҵ�
		public void sendMessage(String msg) {
			out.println(msg);
		}
	}
	
	public static void main(String[] args) {
		new ChatServer1();
	}
}