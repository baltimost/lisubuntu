//: ObjectSerialization.java

//package g3ds.joop.ch7;

import java.io.*;

public class ObjectSerialization{
	public static void main(String[] args) 
		throws IOException,ClassNotFoundException{
		//创建可串行化的 st对象
		Student st=new Student(20010901,"黎明",20,"计算机系");
		
		//与ObjectOutputStream联系起来
		FileOutputStream fout=new FileOutputStream("data.ser");
		ObjectOutputStream sout=new ObjectOutputStream(fout);
		
		try{
			//输出流将对象状态存入文件"data.ser"
			sout.writeObject(st);  
			sout.close();
		}catch(IOException e){}
	
		st=null;
		// st对象与ObjectInputStream联系起来
		FileInputStream fin=new FileInputStream("data.ser");
		ObjectInputStream sin=new ObjectInputStream(fin);
		
		try{ 
			//输入流将对象状态从文件"data.ser"读出
			st=(Student)sin.readObject(); 
			sin.close();
		}catch(IOException e){}
		
		//输出验证
		System.out.println("学生信息:");
		System.out.println("学号: " + st.id);
		System.out.println("姓名: " + st.name);
		System.out.println("年龄: " + st.age);
		System.out.println("院系: " + st.department);
	}
}


//Student类实现Serializable接口
class Student implements Serializable{
	//静态和临时变量都不需要串行化
	static int total;//
	transient boolean isEnrolled;//
	
	//声明与学生有关的变量
	int id;
	String name;
	int age;
	String department;
	
	Student(int id, String name, int age, String department){
		this.id=id;
		this.name=name;
		this.age=age;
		this.department=department;
		total++;
		isEnrolled=true;
	}
	
	/*
	//一般可不重写，定制串行化时需要重写writeObject()方法
	private void writeObject(ObjectOutputStream out)throws IOException
	{
		out.writeInt(id);
		out.writeInt(age);
		out.writeUTF(name);
		out.writeUTF(department);
	}
	
	//一般可不重写，定制串行化时需要重写readObject()方法
	private void readObject(ObjectInputStream in)throws IOException
	{
		id=in.readInt();
		age=in.readInt();
		name=in.readUTF();
		department=in.readUTF();
	}
	//*/
}