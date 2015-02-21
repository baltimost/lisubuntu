//: EmbeddedLayoutDemo.java

//package g3ds.joop.ch9;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EmbeddedLayoutDemo extends JFrame{
	public EmbeddedLayoutDemo(){
		super("EmbeddedLayoutDemo");
		
		Container pane=getContentPane();
		
		pane.add(getHeader(), BorderLayout.NORTH);
		pane.add(getTextArea(), BorderLayout.CENTER);
		pane.add(getButtonPanel(), BorderLayout.SOUTH);
	}
	
	protected JComponent getHeader(){
		JLabel label =new JLabel("Embedded Layout Manager Demo", JLabel.CENTER);
		label.setFont(new Font("Courier", Font.BOLD, 16));
		return label;
	}
	
	protected JComponent getTextArea(){
		return new JTextArea(6,32);
	}
	
	protected JComponent getButtonPanel(){
		JPanel inner=new JPanel();
		inner.setLayout(new GridLayout(1,2,10,0));
		inner.add(new JButton("OK"));
		inner.add(new JButton("Cancel"));
		
		JPanel outer=new JPanel();
		outer.setLayout(new FlowLayout());
		outer.add(inner);
		
		//如果return inner两个按钮的效果不太好
		//return inner;
		
		//如果return outer两个按钮的效果则好得多
		return outer;
	}
	
	public static void main(String[] args){
		EmbeddedLayoutDemo frame =new EmbeddedLayoutDemo();
		
		frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}