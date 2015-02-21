//: Person.java

//package g3ds.joop.ch5;

import java.util.Vector;

public class Person {
	// 设定个人信息
	private String name;
	private int age;

	//定义用于记录一个人爱好的集合
	private Vector hobbies = new Vector();

	//取得一个人的爱好集合
	public Hobby[] getHobbies() { 
		//把集合中的元素转换成Hobby类型并以数组的方式返回
		return (Hobby[]) hobbies.toArray(new Hobby[0]);
	}
	
	//增加一项爱好
	public void addHobby(String hobbyName) {
		hobbies.add(new Hobby(hobbyName, this));
	}
	
	
	public Person(String name, int age) {
		this.name = name; 
		this.age = age;
	}
}