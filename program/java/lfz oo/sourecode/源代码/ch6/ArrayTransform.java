//: ArrayTransform.java

//package g3ds.joop.ch6;

public class ArrayTransform{
	public static void abs(int[] values){
		synchronized(values){
			for(int i=0; i<values.length; i++){
				if(values[i]<0)
					values[i]=-values[i];
			}
		}
	}	
}