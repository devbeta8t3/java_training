package net.problem;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import net.ChatProtocol3;

class TalkAWT extends MFrame implements ActionListener {

	TextField idTf, pwTf;
	Label logo, idl, pwl, msgl;
	Button logBtn;
	Socket sock;
	BufferedReader in;
	PrintWriter out;
	String id;
	String ip = "127.0.0.1";
	int port = 8005;
	String title = "Talk 1.0";
	String label[] = {"ID와 PWD를 입력하세요.", "ID와 PWD를 확인하세요."};

	public TalkAWT() {
		super(450, 400, new Color(200, 100, 200));
		setLayout(null);
		setTitle(title);
		logo = new Label(title);
		logo.setFont(new Font("Dialog", Font.BOLD, 50));

		idl = new Label("ID");
		pwl = new Label("PWD");
		idTf = new TextField("aaa");
		pwTf = new TextField("1234");
		logBtn = new Button("로그인");
		msgl = new Label(label[0]);
		logo.setBounds(100, 50, 250, 100);
		idl.setBounds(150, 200, 50, 20);
		idTf.setBounds(200, 200, 100, 20);
		pwl.setBounds(150, 230, 50, 20);
		pwTf.setBounds(200, 230, 100, 20);
		logBtn.setBounds(150, 260, 150, 40);
		msgl.setBounds(150, 320, 150, 40);
		logBtn.addActionListener(this);
		add(logo);
		add(idl);
		add(idTf);
		add(pwl);
		add(pwTf);
		add(logBtn);
		add(msgl);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if (obj==logBtn) {		// logBtn 클릭
			if (sock==null) {	// 처음 connect 시도이면 connect() 메소드 실행
				connect();
			}
		}
		
		id = idTf.getText().trim();	// id Text field의 내용으로 변수 id를 초기화
		out.println(ChatProtocol3.ID+ ":" +id+ ";" +pwTf.getText().trim()); // ID:id;비번 TalkServer가 읽는다.
		
		// ID:id;pw 형식이면 로그인 절차 진행
		try {
			String line = in.readLine();			
			System.out.println("line : " +line);	// test - line 내용 확인
			int idx = line.indexOf(':');			// ':' 기준으로 문자열 분리
			String cmd = line.substring(0, idx);	// 앞쪽 문자열로 cmd 초기화
			String data = line.substring(idx+1);	// 뒤쪽 문자열로 data 초기화
			
			if (cmd.equals(ChatProtocol3.ID)) {
				if (data.equals("F")) {
					msgl.setForeground(Color.RED);
					msgl.setText(label[1]);
				}
				else if (data.equals("C")) {
					msgl.setForeground(Color.BLUE);
					msgl.setText(label[2]);
				}
				else if (data.equals("T")) {
					dispose();						// LoginAWT 창 사라지고,
					new TalkClient(in, out, id);	// 새로운 채팅창 등장!!!
				}
			}
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void connect() {
		try {
			sock = new Socket(ip, port);
			in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			out = new PrintWriter(sock.getOutputStream(), true); // true: auto flush
			System.out.println(sock+ " 접속됨...");		
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new TalkAWT();
	}
}
