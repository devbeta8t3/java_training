package java_Ch11_Swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ListChangeEx extends JFrame {
	
	private JTextField tf = new JTextField(10);
	private Vector<String> v = new Vector<String>();
	private JList<String> nameList = new JList<String>(v);
	
	private Container c;
	
	public ListChangeEx() {
		setTitle("리스트 변경 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(new JLabel("이름 입력 후 <Enter> 키"));
		c.add(tf);
		
		v.add("황기태");
		v.add("이재문");
		nameList.setVisibleRowCount(5);
		nameList.setFixedCellWidth(100);
		c.add(new JScrollPane(nameList));
		
		setSize(300, 300);
		setVisible(true);
		
		// JTextField에 ActionListener 등록. <Enter>키 처리
		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource();
				v.add(t.getText());				// 벡터 v에 입력받은 텍스트 추가
				t.setText("");					// 텍스트필드 reset
				nameList.setListData(v);		// 이름리스트에 추가된 벡터값 제공
			}
		});
	}
	
	public static void main(String[] args) {
		// Generated by SH Lee
		new ListChangeEx();
	}

}