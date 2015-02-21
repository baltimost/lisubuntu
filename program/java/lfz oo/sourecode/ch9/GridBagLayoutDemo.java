//: GridBagLayoutDemo.java 

//package g3ds.joop.ch9;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GridBagLayoutDemo extends JFrame{
	public GridBagLayoutDemo(){
		super("GridBagLayoutDemo");
		
		Container c = getContentPane();
		
		//设置布局管理
		c.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc=new GridBagConstraints();
		
		//设置约束条件
		gbc.fill=GridBagConstraints.BOTH;
		gbc.anchor=GridBagConstraints.CENTER;
		gbc.insets=new Insets(15,5,10,0);
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridwidth=3;
		gbc.gridheight=3;
		gbc.weightx=1.0;
		gbc.weighty=1.0;
		
		c.add(new JButton("Button 1"), gbc);
		
		//改变约束条件
		gbc.gridx=3;
		gbc.gridy=0;
		gbc.gridwidth=GridBagConstraints.REMAINDER;
		gbc.gridheight=1;
		gbc.weightx=0.0;
		gbc.weighty=0.0;
		c.add(new JButton("Button 2"), gbc);
		
		gbc.fill=GridBagConstraints.BOTH;
		gbc.gridx=3;
		gbc.gridy=1;
		gbc.gridwidth=1;
		gbc.gridheight=2;
		c.add(new JButton("Button 3"), gbc);
	}
	
	public static void main(String[] args) {
        GridBagLayoutDemo frame = new GridBagLayoutDemo();
        
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}