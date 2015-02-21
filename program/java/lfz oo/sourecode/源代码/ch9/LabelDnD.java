//: LabelDnD.java

//package g3ds.joop.ch9;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class LabelDnD extends JPanel {
	JTextField textField;
	JLabel label;

	public LabelDnD() {
		super(new GridLayout(2, 1));
		textField = new JTextField(40);
		
		//设置textField支持拖放
		textField.setDragEnabled(true);
		JPanel tfpanel = new JPanel(new GridLayout(1,1));
		TitledBorder t1 = BorderFactory.createTitledBorder(
			"JTextField: drag and drop is enabled");
		tfpanel.add(textField);
		tfpanel.setBorder(t1);

		label = new JLabel("I'm a Label!", SwingConstants.LEADING);
		label.setTransferHandler(new TransferHandler("text"));

		MouseListener listener = new DragMouseAdapter();
		
		//设置label支持拖放
		label.addMouseListener(listener);
		JPanel lpanel = new JPanel(new GridLayout(1,1));
		TitledBorder t2 = BorderFactory.createTitledBorder(
			"JLabel: drag from or drop to this label");
		lpanel.add(label);
		lpanel.setBorder(t2);

		add(tfpanel);
		add(lpanel);
		setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
	}

	private class DragMouseAdapter extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			JComponent c = (JComponent)e.getSource();
			TransferHandler handler = c.getTransferHandler();
			handler.exportAsDrag(c, e, TransferHandler.COPY);
		}
	}

    private static void createAndShowGUI() {
		//显示Java风格的窗体装饰
		JFrame.setDefaultLookAndFeelDecorated(true);

		//创建一个JFrame对象
		JFrame frame = new JFrame("LabelDnD");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//创建扩展JPanel类的LabelDnD对象
		JComponent newContentPane = new LabelDnD();
		//内容面板必须是不透明的
		newContentPane.setOpaque(true); 
		//将它放到JFrame对象的内容面板中
		frame.setContentPane(newContentPane);

		//显示窗体
		frame.pack();
		frame.setVisible(true);
	}
	
	//测试
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
    }
}