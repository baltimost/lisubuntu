//:Roster.java

//package g3ds.joop.ch5;

import java.util.Vector;

public class Roster {
	//记录最多登记人数
	protected int capacity;
	protected Vector students;

	public Roster(int max) {
		capacity = max;
		students = new Vector();
	}

	//将报名人员登记到表中，登记前用变量allowExcess判断是否额满
	public boolean addStringToVector(String name, boolean allowExcess){
		if (!allowExcess) {
			if (students.size() >= capacity)
				return false;
		}
		
		students.addElement(name);
		return true;
	}
}