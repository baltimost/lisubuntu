//: InnerClassDemo.java

//package g3ds.joop.ch9;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InnerClassDemo extends JFrame{
	private Button b;
	
	public InnerClassDemo(){
		super("InnerClassDemo");
		
		Container c = getContentPane();
		
		b = new Button("Quit");
		//内部类监听方式
		b.addActionListener(new QuitHandler());
		c.add(b, BorderLayout.CENTER);
	}

	public static void main(String[] args){
		InnerClassDemo app = new InnerClassDemo();
		
		app.pack();
		app.setVisible(true);
	}

	class QuitHandler  implements ActionListener{
		//实现监听器接口的方法
		public void actionPerformed(ActionEvent e){
			System.exit(0);
		}
	}
}