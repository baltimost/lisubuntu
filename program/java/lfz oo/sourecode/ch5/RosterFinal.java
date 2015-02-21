//:RosterFinal.java

//package g3ds.joop.ch5;

import java.util.Vector;

public class RosterFinal{
	protected int capacity;
	protected Vector students;

	public RosterFinal(int max) {
		capacity = max;
		students = new Vector();
	}
	
	//
	public void enrollStudent(String name) {
		students.addElement(name);
	}
	
	//
	public boolean enrollStudentConditionally(String name) {
		boolean isEnrolled = false;
		
		if (students.size() < capacity) {
			enrollStudent(name);
			isEnrolled = true;
		}
		
		return isEnrolled;
	}
}