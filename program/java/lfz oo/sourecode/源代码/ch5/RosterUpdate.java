//:RosterUpdate.java

//package g3ds.joop.ch5;

import java.util.Vector;

public class RosterUpdate{
	protected int capacity;
	protected Vector students;

	public RosterUpdate(int max) {
		capacity = max;
		students = new Vector();
	}

	//登记操作
	public void addStringToVector(String name) {
		students.addElement(name);
	}
	
	//对登记是否额满进行判断
	public boolean conditionalAddStringToVector(String name) {
		if (students.size() >= capacity)
			return false;
    
		addStringToVector(name);
		
		return true;
  }
}