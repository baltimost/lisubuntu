//: ApplicationGUI.java

//package g3ds.joop.ch9;

/*设计Swing GUI，以下3个包通常都需要导入*/
//调用Swing组件时
import javax.swing.*;
//调用AWT一些底层组件时，如Container
import java.awt.*;
//调用AWT事件时，但本类暂没有事件处理
import java.awt.event.*;

//JFrame是自定义Swing应用程序类继承的直接父类
public class ApplicationGUI extends JFrame {
	//声明一个容器
	Container c;
	//声明组件，组件更多时也在此声明
	JLabel label;
	
	//通常在构造方法中完成组件的初始化
	public ApplicationGUI() {
		//实现为窗口赋标题
		super("Application GUI");

		//得到当前实例的内容面板，为方便使用，通常声明一个容器引用它
		c = getContentPane();
		
		//初始化一个带图标的Swing标签
		Icon icon = new ImageIcon("swing.gif");
		label = new JLabel("Swing标签", icon, SwingConstants.CENTER);
		
		//并把该标签添加到内容面板的中心位置
		c.add(label, BorderLayout.CENTER);
		
		//如果有其它组件，其实就是重复以上两小段语句...
	}
	
	//测试
	public static void main(String[] args) {
		//创建实例
		ApplicationGUI f = new ApplicationGUI();
		
		//设置窗口大小，pack方法以最适合的尺寸显示
		f.pack();
		//设置窗口可见
		f.setVisible(true);
		//设置窗口清除操作
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}