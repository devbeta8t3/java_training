package java_Ch10_Event;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class IndepClassListener extends JFrame {
	
	public IndepClassListener() {
		
		setTitle("Action 이벤트 리스터 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton btn = new JButton("Action");
		btn.addActionListener(new MyActionListener()); 	// Actio 리스너 달기
		c.add(btn);
		
		setSize(350, 150);
		setVisible(true);
	}

	public static void main(String[] args) {
		// Generated by SH Lee
		new IndepClassListener();
	}

}
