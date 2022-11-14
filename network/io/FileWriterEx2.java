package io;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 간단한 채팅 프로그램
 * 	채팅을 입력하고 엔터를 누르면
 * 		출력창에 채팅이 누적된다.
 * 			저장버튼을 누르면 txt 파일로 저장된다.
 * @author 정동진 at busanit
 *
 */

public class FileWriterEx2 extends MFrame implements ActionListener{
	
	TextArea ta;		// 채팅 출력창
	TextField tf;		// 채팅 입력칸
	Button save;		// 저장 버튼
	
	public FileWriterEx2() {
		super(300, 400);
		setTitle("가나다FileWriterFrameEx1");
		add(ta=new TextArea());
		Panel p = new Panel();
		p.add(tf = new TextField(30));
		p.add(save = new Button("SAVE"));
		ta.setEditable(false);
		tf.addActionListener(this);
		save.addActionListener(this);
		add(p,BorderLayout.SOUTH);
		validate();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();	// 소스는 이벤트를 발생시킨 컴포넌트 
		if (obj == tf) {
			ta.append(tf.getText()+ "\n");
			tf.setText("");
			tf.requestFocus();
		}
		else if (obj == save) {
			saveFile(ta.getText());
			ta.setText("");
		}
	}
	
	public void saveFile(String str) {
		try {
			long name = System.currentTimeMillis();
			
			FileWriter fw = new FileWriter("io/" +name+ ".txt");
			fw.write(str);
			fw.flush();
			fw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		new FileWriterEx2();
		
		// 1970.01.01 00:00부터 현재까지 1/1000 초 단위로 계산
//		long name = System.currentTimeMillis();
//		System.out.println(name);
	}
}






