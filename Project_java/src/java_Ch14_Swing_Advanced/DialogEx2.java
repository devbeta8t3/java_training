package java_Ch14_Swing_Advanced;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class DialogEx2 extends JFrame {
	
	private MyModalDialog dialog;
	
	public DialogEx2() {
		super("DialogEx2 예제 프레임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btn = new JButton("Show Modal Dialog");
		
		dialog = new MyModalDialog(this, "Test ModalDialog");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
				
				String text = dialog.getInput();
				
				if (text==null)
					return;
				
				JButton btn = (JButton)e.getSource();
				btn.setText(text);
			}
		});
		
		getContentPane().add(btn);
		setSize(250, 200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// Generated by SH Lee
		new DialogEx2();
	}

}

class MyModalDialog extends JDialog {
	
	private JTextField tf = new JTextField(10);
	private JButton okButton = new JButton("OK");
	
	public MyModalDialog(JFrame frame, String title) {
		super(frame, title, true);							// 모달 다이얼로그로 설정 (독점)
		setLayout(new FlowLayout());
		add(tf);
		add(okButton);
		setSize(200, 100);
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}
	
	public String getInput() {				//  getInput() : 텍스트필드에 텍스트가 없으면 null, 텍스트가 있으면 텍스트 반환
		if (tf.getText().length()==0)
			return null;
		else
			return tf.getText();
	}
	
}
