//: SpringLayoutDemo.java

//package g3ds.joop.ch9;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SpringLayoutDemo extends JFrame{
	private Container c;
    public SpringLayoutDemo() {
		super("SpringLayoutDemo");
		
        c = getContentPane();
        
        SpringLayout layout = new SpringLayout();
        c.setLayout(layout);

		JLabel label = new JLabel("Label: ");
		JTextField textField = new JTextField("Text field", 15);
		c.add(label);
		c.add(textField);

        //调整标签和容器之间的位置，使之位于(5,5).
        layout.putConstraint(SpringLayout.WEST, label,
                             5,
                             SpringLayout.WEST, c);
        layout.putConstraint(SpringLayout.NORTH, label,
                             5,
                             SpringLayout.NORTH, c);

        //调整文本框和标签之间的位置，使之位于（标签右边+ 5, 5).
        layout.putConstraint(SpringLayout.WEST, textField,
                             5,
                             SpringLayout.EAST, label);
        layout.putConstraint(SpringLayout.NORTH, textField,
                             5,
                             SpringLayout.NORTH, c);

        //调整内容面板: 使之右边界距文本框5像素，距组件底边5像素
        layout.putConstraint(SpringLayout.EAST, c,
                             5,
                             SpringLayout.EAST, textField);
        layout.putConstraint(SpringLayout.SOUTH, c,
                             5,
                             SpringLayout.SOUTH, textField);
    }

	public static void main(String[] args) {
        SpringLayoutDemo frame = new SpringLayoutDemo();
        
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
