//: CardLayoutDemo

//package g3ds.joop.ch9;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CardLayoutDemo extends JFrame implements ActionListener{
	private String[] name = {
		"君自故乡来", 
		"应知故乡事", 
		"来日绮窗前", 
		"寒梅著花未"
	};   
	private JLabel[] card = new JLabel[name.length];
	private JButton previous=new JButton("上一张");
	private JButton next=new JButton("下一张");
	
	private CardLayout cardLayout;
	private JPanel cp, sp;
	private Container c;
	
	public CardLayoutDemo(){
		super("CardLayoutDemo");
		
		c = getContentPane();
		
		//把一个容器的布局管理设为CardLayout
		cardLayout=new CardLayout();
		cp=new JPanel();
		cp.setLayout(cardLayout);
		
		//往其中添加组件
		for (int i=0; i<name.length; i++){
			card[i] = new JLabel(name[i], JLabel.CENTER);
			card[i].setFont(new Font("隶书", Font.PLAIN, 28));
			//并为添加的组件命名
			cp.add(card[i], name[i]);
		}
		
		//显示指定的组件
		cardLayout.show(cp, "寒梅著花未");
		
		//设计另一个容器管理卡片布局的移动操作
		sp=new JPanel();
		sp.add(previous);
		sp.add(next);
		
		//将以上2个面板容器放入当前实例的内容面板
		c.add(cp, BorderLayout.CENTER);
		c.add(sp, BorderLayout.SOUTH);
		
		//授权监听
		previous.addActionListener(this);
		next.addActionListener(this);
	}
	
	//监听器的响应
	public void actionPerformed(ActionEvent e){
		String command=e.getActionCommand();
		
		/*卡片移动的操作*/
		if (command.equals("上一张"))
			cardLayout.previous(cp);
		else if (command.equals("下一张"))
			cardLayout.next(cp);
	}
	
	public static void main(String[] args) {
        CardLayoutDemo frame = new CardLayoutDemo();
        
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}