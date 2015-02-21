//: StyleChooser.java

//package g3ds.joop.ch9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StyleChooser extends JFrame{
	public StyleChooser(){
		super("StyleChooserDemo");
		Container contentPane = getContentPane();
		
		contentPane.add(new ControlPanel(), BorderLayout.NORTH);
		contentPane.add(new ComponentPanel(), BorderLayout.SOUTH);
	}
	
	
	class ComponentPanel extends JPanel {
		ComponentPanel() {
			//在面板边框上添加标题
			setBorder(
				BorderFactory.createTitledBorder("Components Show"));
			
			//将一些组件加入面板中
			add(new JCheckBox("Checkbox", true));
			add(new JRadioButton("RadioButton"));
			add(new JButton("Button"));
			add(new JLabel("Label:"));
			add(new JTextField("TextField"));
		}
	}
	
	
	class ControlPanel extends JPanel {
		//添加单选按钮
		JRadioButton motifButton = new JRadioButton("Motif"),
					 windowsButton = new JRadioButton("Windows"),
					 metalButton = new JRadioButton("Metal", true);

		public ControlPanel() {
			//创建一个事件监听器对象
			ActionListener listener = new RadioHandler();
			
			//创建一个按钮组
			ButtonGroup group = new ButtonGroup();
			group.add(metalButton);
			group.add(windowsButton);
			group.add(motifButton);
			
			//把相应单选按钮加入事件监听器中
			motifButton.addActionListener(listener);
			windowsButton.addActionListener(listener);
			metalButton.addActionListener(listener);
			
			//把按钮加入面板之中
			add(metalButton);
			add(windowsButton);
			add(motifButton);
		}
		
		
		//设计事件监听器类
		class RadioHandler implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				JRadioButton src = (JRadioButton)e.getSource();
	
				//对按钮状态进行跟踪，响应以后改变界面样式设置
				try {
					if(src == motifButton)
						UIManager.setLookAndFeel(
							"com.sun.java.swing.plaf." +
							"motif.MotifLookAndFeel");
							
					else if(src == windowsButton)
						UIManager.setLookAndFeel(
							"com.sun.java.swing.plaf." +
							"windows.WindowsLookAndFeel");
					
					else if(src == metalButton)
						UIManager.setLookAndFeel(
						  "javax.swing.plaf.metal." +
						  "MetalLookAndFeel");
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
				//更新界面
				SwingUtilities.updateComponentTreeUI(getContentPane());
			}
		}
	}
	
	//测试
	public static void main(String[] args) {
		//设定窗口风格，true显示Java风格，false显示本地系统风格
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		StyleChooser frame = new StyleChooser();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(450, 150);
		frame.setVisible(true);
    }
}