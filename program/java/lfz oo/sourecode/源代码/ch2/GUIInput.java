import javax.swing.*;

public class GUIInput{
	public static void main(String[] args){
		JOptionPane pane=new JOptionPane();
		String str=pane.showInputDialog(null, "Please input something for test:");	
		System.out.println(str);
		
		System.exit(0);
	}
}