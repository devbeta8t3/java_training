package net;


import java.awt.Button;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;

public class URLFrameEx1 extends MFrame implements ActionListener {

	TextArea ta;
	TextField tf;
	Button connect;
	Button save;

	public URLFrameEx1() {
		super(500, 500);
		setTitle("ViewHost");
		Panel p = new Panel();
		p.add(tf = new TextField("https://", 40));
		p.add(connect = new Button("connect"));
		p.add(save = new Button("save"));
		ta = new TextArea();
		add("North", p);
		add("Center", ta);
		save.setEnabled(false);
		connect.addActionListener(this);
		save.addActionListener(this);
		tf.addActionListener(this);
		validate();
	}

	@Override 
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String host = tf.getText().trim();	// tf에 있는 text를 가져온다. => host
		
		if (obj==tf || obj==connect) {	
			// 사이트 접속과 동시에 html 코드 ta에 append 한다.
			ta.setText("");	// textarea 초기화
			connectHost(host);	// 메소드 호출
			save.setEnabled(true);	//save 버튼 활성화
		} 
		else if (obj==save) {
			// ta에 문자열을 저장
			createFile(host, ta.getText());	// 메소드 호출
			save.setEnabled(false);	// save 버튼 비활성화
			tf.setText("https://");
			ta.setText("");
			ta.append("저장하였습니다.");
			
		}
	}

	/* host에 접속해서 ta에 코드 출력 */
	private void connectHost(String host) {
		try {
			URL url = new URL(host);
			BufferedReader br = new BufferedReader(
					new InputStreamReader(url.openStream(), "UTF-8"));
			String line = "";
			
			while (true) {
				line = br.readLine();
				if (line==null) break;
				ta.append(line+ "\n");	// ta에 출력
			}
			br.close();
			
		} catch(Exception e) {
			//e.printStackTrace();
			ta.append("해당되는 호스트가 없습니다.");
		}
		
		System.out.println(host);

	}

	/* 출력된 문자열을 파일로 저장 */
	private void createFile(String file, String content) {	//첫번째 매개변수는 파일명 지정
		try {
			FileWriter fw = new FileWriter("net/" +file.substring(8)+ ".txt");	
											// 'https://' 제외하고 파일이름 저장
			fw.write(content);
			fw.flush();
			fw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		URLFrameEx1 ex = new URLFrameEx1();
	}
}








