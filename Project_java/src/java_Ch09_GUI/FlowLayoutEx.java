package java_Ch09_GUI;

import javax.swing.*;
import java.awt.*;

// 예제 9-3

public class FlowLayoutEx extends JFrame {
	
	public FlowLayoutEx() {
		setTitle("FlowLayout Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 종표버튼 클릭시 응용프로그램 종료
		Container c = getContentPane();
		
		c.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40));
		c.add(new JButton("add"));
		c.add(new JButton("sub"));
		c.add(new JButton("mul"));
		c.add(new JButton("div"));
		c.add(new JButton("Calculate"));
		
		setSize(300, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		// Generated by SH Lee
		new FlowLayoutEx();
	}

}
