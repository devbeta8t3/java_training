package java_Ch11_Swing;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderChangeEx extends JFrame {
	
	private JLabel colorLabel;
	private JSlider[] sl = new JSlider[3];
	private Container c;
	
	public SliderChangeEx() {
		setTitle("슬라이더와 Change Event 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		c = getContentPane();
		c.setLayout(new FlowLayout());
		
		colorLabel = new JLabel(" SLIDER EXAMPLE ");
		
		for (int i=0; i<sl.length; i++) {
			sl[i] = new JSlider(JSlider.HORIZONTAL, 0, 255, 128);
			sl[i].setPaintLabels(true);
			sl[i].setPaintTicks(true);
			sl[i].setPaintTrack(true);
			sl[i].setMajorTickSpacing(50);
			sl[i].setMinorTickSpacing(10);
			sl[i].addChangeListener(new MyChangeListener());
			c.add(sl[i]);
		}
		
		sl[0].setForeground(Color.RED);
		sl[1].setForeground(Color.GREEN);
		sl[2].setForeground(Color.BLUE);
		
		int r = sl[0].getValue();
		int g = sl[1].getValue();
		int b = sl[2].getValue();
		
		colorLabel.setOpaque(true);
		colorLabel.setBackground(new Color(r,g,b));			// 초기값 r,g,b = 128, 128, 128
		
		c.add(colorLabel);
		
		setSize(300, 230);
		setVisible(true);
	}
	
	class MyChangeListener implements ChangeListener {		// 액션리스너
		public void stateChanged(ChangeEvent e) {			// 슬라이더의 값을 받아 컬러라벨 배경색 변경
			int r = sl[0].getValue();
			int g = sl[1].getValue();
			int b = sl[2].getValue();
			colorLabel.setBackground(new Color(r,g,b));
		}
	}

	public static void main(String[] args) {
		// Generated by SH Lee
		new SliderChangeEx();
	}

}