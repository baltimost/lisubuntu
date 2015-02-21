//: AboutReference.java

//package g3ds.joop.ch4;

public class AboutReference{
	public static void main(String[] agrs){
		//str开始组建"家庭"
		StringBuffer str=new StringBuffer("Contents");
		//strTest加盟
		StringBuffer strTest=str;
		//"家"中的事是大家的事
		strTest.append(" add Something.");
		
		//看看这个和睦的"家"
		System.out.println("strTest的家: "+strTest);
		System.out.println("str的家: "+str);
		
		//****各种家庭风波上演了****
		//"分道扬镳"型
		strTest=null;
		System.out.println("分道扬镳的strTest: "+strTest);
		
		//"改弦易辙"型
		StringBuffer strLure=new StringBuffer("Give you an apple, then leave him!");
		strTest=strLure;
		System.out.println("改弦易辙的strTest: "+strTest);
		
		//"自立门户"型
		strTest=new StringBuffer("It is my business!");
		System.out.println("自立门户的strTest: "+strTest);
		
		//**** :<( ****
		
		System.out.println("风波之后str的家："+str);
	}
}