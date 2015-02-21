//: HelloWorldApplet.java

//package g3ds.joop.ch2;

import java.awt.Graphics;
import javax.swing.JApplet;

public class HelloWorldApplet extends JApplet {//an applet
	public void paint(Graphics g){
    	g.drawString("Hello World!",150,50); 
    }
}