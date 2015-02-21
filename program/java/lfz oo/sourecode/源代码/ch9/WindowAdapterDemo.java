//: WindowAdapterDemo.java

//package g3ds.joop.ch9;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WindowAdapterDemo extends JFrame{
	public WindowAdapterDemo(){
		super("WindowAdapterDemo");
		
		Container c = getContentPane();
      
		JLabel label = new JLabel("WindowAdapter Here", JLabel.CENTER);
		c.add(label);
		
		//使用适配器类的方式
		addWindowListener(new WindowAdapter(){
			//只重写感兴趣的方法
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}

	public static void main(String[] args){
		WindowAdapterDemo app = new WindowAdapterDemo();
		
		app.setBounds(100, 100, 200, 100);
		app.setVisible(true);
	}
}