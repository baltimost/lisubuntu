//: AppletGUI.java

//package g3ds.joop.ch9;

/*设计Swing GUI，以下3个包通常都需要导入*/
//调用Swing组件时
import javax.swing.*;
//调用AWT一些底层组件时，如Container
import java.awt.*;
//调用AWT事件时，但本类暂没有事件处理
import java.awt.event.*;

//JApplet是自定义Swing小程序类继承的直接父类
public class AppletGUI extends JApplet {
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
}