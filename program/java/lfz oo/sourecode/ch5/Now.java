//: Now.java 1.0 03/06/03

//package g3ds.joop.ch5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DateFormat;

class Now extends JFrame {
	JLabel label;
	DateFormat formatter;
	java.util.Date date;
	Container c;
	
	public Now() {
		c=getContentPane();
		label=new JLabel("Show time here.",JLabel.CENTER);
		
		c.add(label);
		
		formatter=DateFormat.getTimeInstance(DateFormat.LONG);
		
		//设置触发Timer对象的间隔为1秒
		int delay = 1000;
		//编写时事件监听器的内容，定义了一个匿名类
  		ActionListener taskPerformer = new ActionListener() {
      		public void actionPerformed(ActionEvent evt) {
      			//把返回的当前时间格式化
				date=new java.util.Date(System.currentTimeMillis());
          		//经由JLabel对象展示
          		label.setText(formatter.format(date));
      		}
  		};
  		
  		//启动javax.swing.Timer对象
  		new Timer(delay, taskPerformer).start();
		
		//关闭程序的相关处理
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
	}

	public static void main(String args[]) {
		System.out.println("Starting Now...");
		Now mainFrame = new Now();
		mainFrame.setBounds(150,150,150,100);
		mainFrame.setTitle("Now Time");
		mainFrame.setVisible(true);
	}
}