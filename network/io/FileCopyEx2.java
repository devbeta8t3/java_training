package io;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FileDialog;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;

public class FileCopyEx2 extends MFrame implements ActionListener{
	
	Button open, save;
	TextArea ta;
	FileDialog openDialog, saveDialog;
	String sourceDir;
	String sourceFile;
	
	public FileCopyEx2() {
		super(400,500);
		setTitle("FileCopyEx2");
		add(ta = new TextArea());
		Panel p = new Panel();
		p.add(open = new Button("OPEN"));
		p.add(save = new Button("SAVE"));
		ta.setEditable(false);
		open.addActionListener(this);
		save.addActionListener(this);
		add(p,BorderLayout.SOUTH);
		validate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();	// 이벤트의 소스 획득
		if (obj == open) {	// 이벤트의 소스가 open 일때
			openDialog = new FileDialog(this, "파일 열기", FileDialog.LOAD);	// 파일 열기 창 생성
			openDialog.setVisible(true);	// 파일 열기 창이 보임
			
			String dir, file;
			dir = openDialog.getDirectory();	// 선택한 파일의 디렉터리
			file = openDialog.getFile();		// 선택한 파일의 파일명
			fileReader(dir+file);				// fileReader 메소드 호출 - 파일 열기
		}
		else if (obj == save) {	// 이벤트의 소스가 save 일때
			saveDialog = new FileDialog(this, "파일 저장", FileDialog.SAVE);	// 파일 저장 창 생성
			saveDialog.setVisible(true);
			
			String dir, file;
			dir = saveDialog.getDirectory();	// 선택한 파일의 디렉터리
			file = saveDialog.getFile();		// 선택한 파일의 파일명
			fileWriter(dir+file);				// fileWriter 메소드 호출 - 파일 저장
		}
	}
	
	/**
	 * 파일을 읽어 text area에 기록한다.
	 * @param file 불러올 파일
	 */
	public void fileReader(String file){
		try {
			FileReader fr = new FileReader(file);
			
			int c;
			String s = "";
			while ((c=fr.read()) != -1) {	// 파일 내용의 마지막값은 -1 즉, 끝까지 읽는다.
				s = s + (char)c;
			}
			ta.setText(s);					// 읽은 내용을 textarea에 기록한다.
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * text area에 기록된 내용을 파일로 저장한다.
	 * @param file 기록될 파일
	 */
	public void fileWriter(String file){
		try {
			FileWriter fw = new FileWriter(file);
			fw.write(ta.getText());			// textarea의 내용을 받아서 파일에 기록한다.
			
			for (int i=0; i>0; i--) {
				ta.setText("저장하였습니다 - " +i+ "초 후에 사라집니다.");
				Thread.sleep(1000); 	// 1초 단위로 wait
			}
			ta.setText("");	// textarea의 내용을 reset.
			fw.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void main(String[] args) {
		new FileCopyEx2();
	}
}



