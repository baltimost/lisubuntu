//: WindowListenerDemo.java

//package g3ds.joop.ch9;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WindowListenerDemo extends JFrame{
	public WindowListenerDemo(){
		super("WindowListenerDemo");
		
		Container c = getContentPane();
      
		JLabel label = new JLabel("WindowListener Here", JLabel.CENTER);
		c.add(label);

		//使用监听器接口的方式
		addWindowListener(new WindowListener(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
			
			//必须实现所有的方法
			public void windowActivated(WindowEvent e) {}
			public void windowClosed(WindowEvent e) {}
			public void windowDeactivated(WindowEvent e) {}
			public void windowDeiconified(WindowEvent e) {}
			public void windowIconified(WindowEvent e) {}
			public void windowOpened(WindowEvent e) {}
		});
	}

	public static void main(String[] args){
		WindowListenerDemo app = new WindowListenerDemo();
		
		app.setBounds(100, 100, 200, 100);
		app.setVisible(true);
	}
}