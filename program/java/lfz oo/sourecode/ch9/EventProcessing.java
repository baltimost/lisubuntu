//: EventProcessing.java

//package g3ds.joop.ch9;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EventProcessing extends JFrame implements ActionListener{
	private JTextArea textSource, textDestination;
	private JButton btCopy, btCut, btEnter;
	private KeyPress keyPress;
	
	public EventProcessing(){
		super("EventProcessing");
		
		//创建一个实现KeyListener接口的实例
		keyPress=new KeyPress();
		
		Container pane=getContentPane();
		
		pane.add(getHeader(), BorderLayout.NORTH);
		pane.add(getTextArea(), BorderLayout.CENTER);
		pane.add(getButtonPanel(), BorderLayout.SOUTH);
	}
		
	protected JComponent getHeader(){
		JLabel label =new JLabel("事件处理演示", JLabel.CENTER);
		label.setFont(new Font("隶书", Font.PLAIN, 20));
		return label;
	}
	
	protected JComponent getTextArea(){
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(2,1,0,10));
		
		textSource=new JTextArea(10,10);
		JScrollPane scrollPane=new JScrollPane(textSource);
		panel.add(scrollPane);
		
		textDestination=new JTextArea(10,10);
		scrollPane=new JScrollPane(textDestination);
		panel.add(scrollPane);
		return panel;
	}
	
	protected JComponent getButtonPanel(){
		JPanel inner=new JPanel();
		inner.setLayout(new GridLayout(1,2,10,0));
		
		btCopy=new JButton("Copy");
		//采用匿名内部类监听方式
		btCopy.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				textDestination.setText(textSource.getText());
			}
		});
		inner.add(btCopy);
		
		btCut=new JButton("Cut");
		//采用匿名内部类监听方式
		btCut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				textDestination.setText(textSource.getText());
				textSource.setText("");
			}
		});
		inner.add(btCut);
		
		btEnter=new JButton("UsingEnter");
		//采用自我监听方式
		btEnter.addActionListener(this);
		inner.add(btEnter);
		
		JPanel outer=new JPanel();
		outer.setLayout(new FlowLayout());
		outer.add(inner);
		
		return outer;
	}
	
	//内部类监听方式，并用适配器实现
	protected class KeyPress extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			if(e.getKeyCode()==KeyEvent.VK_ENTER)
				textDestination.setText(textSource.getText());
		}
	}
	
	//主类监听器的动作响应
	public void actionPerformed(ActionEvent e){	
		if(e.getActionCommand()=="UsingEnter"){
			//textSource注册KeyListener
			textSource.addKeyListener(keyPress);
			btCopy.setEnabled(false);
			btCut.setEnabled(false);
			btEnter.setText("UsingCopy/Cut");
		}
		else if(e.getActionCommand()=="UsingCopy/Cut"){
			//textSource取消注册KeyListener
			textSource.removeKeyListener(keyPress);
			btCopy.setEnabled(true);
			btCut.setEnabled(true);
			btEnter.setText("UsingEnter");
		}
	}
	
	public static void main(String[] args){
		EventProcessing app =new EventProcessing();
		
		//把窗口显示在屏幕中间的处理语句
		int width = 400;
		int height = 300;
		Toolkit kit=app.getToolkit();
		Dimension wnd=kit.getScreenSize();
		app.setBounds((wnd.width - width)/2, (wnd.height - height)/2, 
						width, height); 
		
		app.setVisible(true);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}