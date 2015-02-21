//: Hobby.java

//package g3ds.joop.ch5;

public class Hobby {
	//用于记录一项爱好的名称
	private String name;

	//用于记录拥有当前爱好项的人
	private Person person;

	public Person getPerson() { 
		return person; 
	}
	
	public Hobby(String name, Person person) {
		this.name = name; 
		this.person = person;
	}

	public String getName() { 
		return name; 
	}

}