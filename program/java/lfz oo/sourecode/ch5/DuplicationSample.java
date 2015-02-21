//: DuplicationSample.java

//package g3ds.joop.ch5;

public class DuplicationSample {
	protected int firstValue;
	protected String secondValue;
	protected Integer thirdValue;

	public DuplicationSample(int first, String second, Integer third) {
		firstValue = first;
		secondValue = second;
		thirdValue = third;
	}
	
	public DuplicationSample(int first, String second) {
		firstValue = first;
		secondValue = second;
		thirdValue = new Integer(0);
		
		//this(first, second, new Integer(0));
	}
}