package net.problem;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;

public class TalkClient extends MFrame implements ActionListener, Runnable {

	Button saveBtn, sendBtn;
	TextField sendTf;
	TextArea contentArea;
	List chatList;
	Socket sock;
	BufferedReader in;
	PrintWriter out;
	String title = "Talk 1.0";
	boolean flag = false;
	String id;
	String label[] = { "SAVE", "SEND"};

	public TalkClient(BufferedReader in, PrintWriter out, String id) {
		super(450, 400);
		this.in = in;
		this.out = out;
		this.id = id; 
		setTitle(title + " - " + id + "님 반갑습니다.");
		
		//패널 생성 및 요소 추가
		Panel p1 = new Panel();
		p1.setBackground(new Color(200, 100, 200));
		p1.add(saveBtn = new Button(label[0]));
		Panel p2 = new Panel();
		p2.setBackground(new Color(200, 100, 200));
		p2.add(sendTf = new TextField("", 50));
		p2.add(sendBtn = new Button(label[1]));
		
		// 액션 리스너
		saveBtn.addActionListener(this);
		sendTf.addActionListener(this);
		sendBtn.addActionListener(this);
		
		// 프레임창에 패널, 텍스트영역 추가하기
		add(p1, BorderLayout.NORTH);
		add(contentArea = new TextArea());
		add(p2, BorderLayout.SOUTH);
		
		new Thread(this).start();
		validate();
		
		chatList = new List();
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj==saveBtn) {	// Save 버튼을 누르면 텍스트 파일로 저장
			String content = contentArea.getText();
			long fileName = System.currentTimeMillis();
			
			try {
				FileWriter fw = new FileWriter("net/problem/"+fileName+".txt");
				fw.write(content);
				fw.close();
				contentArea.setText("");
				new MDialog(this, "Save", "대화내용을 저장하였습니다.");
			} 
			catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		else if(obj==sendBtn ||obj==sendTf) {	// Send 버튼을 누르거나 입력창에 Enter,
			String str = sendTf.getText();

			if(filterMgr(str)) {	// 금지어 true 이면 경고창
				new MDialog(this, "경고", "입력하신 단어는 금지어입니다.");
				return;
			}
			
			sendMessage(TalkProtocol.CHATALL+":"+str);

			sendTf.setText("");		// 입력창 지우기
			sendTf.requestFocus();
		}
	}

	public void run() {
		try {
			while(true) {
				String line = in.readLine();
				if(line==null)
					 break;
				else
					routine(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void routine(String line) {
		int idx = line.indexOf(':');
//		String cmd = line.substring(0, idx);	// CHATALL:내용 형식만 오기때문에 주석처리
		String data = line.substring(idx+1);
		
		contentArea.append(data+"\n");
	}
	
	public void sendMessage(String msg) {
		out.println(msg);
	}

	public boolean filterMgr(String msg){
		boolean flag = false;	// flag - true:금지어
		String str[] = {"병신","씨발","새끼","니미","fuck"};
		StringTokenizer st = new StringTokenizer(msg);	//생략시 구분자는 공백
		String msgs[] = new String[st.countTokens()];
		
		for (int i = 0; i < msgs.length; i++) {
			msgs[i] = st.nextToken();
		}
		for (int i = 0; i < str.length; i++) {
			if(flag) 
				break;
			for (int j = 0; j < msgs.length; j++) {
				if(str[i].equalsIgnoreCase(msgs[j])) {
					flag = true;
					break; 
				}
			}
		}
		return flag;
	}

	/* 팝업창 클래스 */
	class MDialog extends Dialog implements ActionListener{
		
		Button ok;
		TalkClient ct2;
		
		public MDialog(TalkClient ct2,String title, String msg) {
			super(ct2, title, true);
			this.ct2 = ct2;
			
			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
			     dispose();
			    }
			});
			
			setLayout(new GridLayout(2,1));
			Label label = new Label(msg, Label.CENTER);
			add(label);
			add(ok = new Button("확인"));
			ok.addActionListener(this);
			layset();
			setVisible(true);
			validate();
		}
		
		public void layset() {
			int x = ct2.getX();
			int y = ct2.getY();
			int w = ct2.getWidth();
			int h = ct2.getHeight();
			int w1 = 150;
			int h1 = 100;
			setBounds(x + w / 2 - w1 / 2, 
					y + h / 2 - h1 / 2, 200, 100);
		}

		public void actionPerformed(ActionEvent e) {
			sendTf.setText("");
			dispose();
		}
	}
}
