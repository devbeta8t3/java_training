package java_Ch10_Event;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class InnerClassListener extends JFrame {
	
	InnerClassListener(){
		
		setTitle("Action 이벤트 리스터 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton btn = new JButton("Action");
		btn.addActionListener(new MyActionListener());
		c.add(btn);
		
		setSize(350, 150);
		setVisible(true);
	}
	
	private class MyActionListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			
			if (b.getText().equals("Action"))
				b.setText("액션");
			else 
				b.setText("Action");
			
			InnerClassListener.this.setTitle(b.getText()); 	// 프레임 타이틀에 버튼 문자열을 출력
		}
	}

	public static void main(String[] args) {
		
		new InnerClassListener();
	}

}
