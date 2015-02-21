//: AppletLifeCycle.java

//package g3ds.joop.ch2;

import javax.swing.JApplet;
import java.awt.Graphics;

public class AppletLifeCycle extends JApplet{
	//记录字符串的变量
	StringBuffer buffer;
	
	public void init(){
		//加载时创建相应的对象
		buffer = new StringBuffer();
		
		addItem("加载... ");
	}
	
	public void start(){
		addItem("运行... ");
	}
	
	public void stop(){
		addItem("停止... ");
	}
	
	public void destroy(){
		addItem("正在删除...");
	}
	
	//addItem方法用于辅助显示
	void addItem(String newWord){
		//在标准输出终端显示所执行方法中的字符串
		System.out.println(newWord);
		
		//把字符串加入StringBuffer对象中
		buffer.append(newWord);
		
		//刷新
		repaint();
	}
	
	public void paint(Graphics g){
		//设定显示区域大小
		g.drawRect(0, 0, getSize().width - 1, getSize().height - 1);
		
		//把StringBuffer对象中的内容绘制出来
		g.drawString(buffer.toString(), 5, 15);
	}
}