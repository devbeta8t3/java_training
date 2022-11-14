package net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ChatServer2 {

	Vector<ClientThread2> vc;
	ServerSocket server;
	int port = 8002;
	
	public ChatServer2() {
		try {
			vc = new Vector<ClientThread2>();
			server = new ServerSocket(port);
		} catch (Exception e) {
			System.err.println("Error in Server");
			e.printStackTrace();
			System.exit(1);
		}
		System.out.println("****Chat Server 2.0************************");
		System.out.println("** 클라이언트 접속을 기다리고 있습니다.  **");
		System.out.println("****************************************");
		try {
			while(true) {
				Socket sock = server.accept();
				ClientThread2 ct = new ClientThread2(sock);
				ct.start();
				vc.addElement(ct);
			}
		} catch (Exception e) {
			System.err.println("Error in Socket");
			e.printStackTrace();
		}
	}
	
	public void sendAllMessage(String msg) {
		for (int i = 0; i < vc.size(); i++) {
			ClientThread2 ct = vc.elementAt(i);
			ct.sendMessage(msg);
		}
	}
	
	public void removeClient(ClientThread2 ct) {
		vc.remove(ct);
	}
	
	/* 접속된 모든 id 리스트 리턴 */ //���ӵ� ��� id ����Ʈ ���� ex) aaa;bbb;ccc;ddd;ȫ�浿;
	public String getIds() {
		String ids = "";
		for (int i = 0; i < vc.size(); i++) {
			ClientThread2 ct = vc.get(i);
			ids+=ct.id+";";
		}
		return ids;
	}
	
	//�Ű����� id������ ClientThread2�� �˻�
	public ClientThread2 findClient(String id) {
		ClientThread2 ct = null;
		for (int i = 0; i < vc.size(); i++) {
			ct = vc.get(i);
			if(ct.id.equals(id)) {//�Ű����� id�� Client�� id�� ���ٸ�...
				break;
			}
		}//--for
		return ct;
	}//--findClient
	
	class ClientThread2 extends Thread{
		
		Socket sock;
		BufferedReader in;
		PrintWriter out;
		String id;
		
		public ClientThread2(Socket sock) {
			try {
				this.sock = sock;
				in = new BufferedReader(
						new InputStreamReader(sock.getInputStream()));
				out = new PrintWriter(sock.getOutputStream(), true);
				System.out.println(sock + " ���ӵ�...");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			try {
				out.println("����Ͻ� ���̵� �Է��ϼ���.");
				while(true) {
					String line = in.readLine();
					if(line==null)
						break;
					else
						routine(line);
				}
			} catch (Exception e) {
				removeClient(this);
				System.err.println(sock + "["+id+"] ������...");
			}
		}
		
		public void routine(String line) {}
		
		public void sendMessage(String msg) {
			out.println(msg);
		}
	}
	
	public static void main(String[] args) {
		new ChatServer2();
	}
}








