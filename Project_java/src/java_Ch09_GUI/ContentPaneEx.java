package java_Ch09_GUI;

import javax.swing.*;
import java.awt.*;

public class ContentPaneEx extends JFrame {
	
	public ContentPaneEx() {
		
		setTitle("ContentPane과 JFrame");				// 타이틀 표시
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 종표버튼 클릭시 응용프로그램 종료
		
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.ORANGE);		// Pane 배경: 오렌지색
		contentPane.setLayout(new FlowLayout());		// 콤퍼넌트 배치 유형 4가지 중 FlowLaout
		
		contentPane.add(new JButton("OK"));				// 버튼1
		contentPane.add(new JButton("Cancel"));			// 버튼2
		contentPane.add(new JButton("Ignore"));			// 버튼3
		
		setSize(300, 150);								// 크기
		setVisible(true);								// 보이기
	}

	public static void main(String[] args) {
		// Generated by SH Lee
		
		new ContentPaneEx();

	}

}