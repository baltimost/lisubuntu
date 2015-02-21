//: AnAGUI.java

//package g3ds.joop.ch9;

/*设计Swing GUI，以下3个包通常都需要导入*/
//调用Swing组件时
import javax.swing.*;
//调用AWT一些底层组件时，如Container
import java.awt.*;
//调用AWT事件时，但本类暂没有事件处理
import java.awt.event.*;

/* 兼具Swing小程序和应用程序功能的自定义类依然选用
   JApplet作为直接父类，以便浏览器的加载*/
public class AnAGUI extends JApplet {
	//声明一个容器
	Container c;
	//声明组件，组件更多时也在此声明
	JLabel label;
	
	//通常重写的init方法，用来完成组件的初始化
	public void init() {
		//得到当前实例的内容面板，为方便使用，通常声明一个容器引用它
		c = getContentPane();
		
		//初始化一个带图标的Swing标签
		Icon icon = new ImageIcon("swing.gif");
		label = new JLabel("Swing标签", icon, SwingConstants.CENTER);
		
		//并把该标签添加到内容面板的中心位置
		c.add(label, BorderLayout.CENTER);
		
		//如果有其它组件，其实就是重复以上两小段语句...
	}
	
	//在此添加main方法，以便可以用java执行
	public static void main(String[] args) {
		//创建一个自定义类的实例
		JApplet applet = new AnAGUI();
		
		//并调用其init方法，注意不是在浏览器中，init方法不会自动调用
		applet.init();
		
		//创建一个窗口，用来供显示用
		final JFrame f = new JFrame();
		
		//这是一个经典语句：
		//把JApplet实例内容面板的内容经由JFrame实例内容面板展示出来
		f.setContentPane(applet.getContentPane());
		
		//设置窗口标题
		f.setTitle("AnA GUI");
		//设置窗口大小及位置
		f.setBounds(100,100,300,200);
		//设置窗口可见
		f.setVisible(true);
		//设置窗口清除操作
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
