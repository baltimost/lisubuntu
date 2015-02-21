//: InheritanceChain.java

//package g3ds.joop.ch4;

public class InheritanceChain{
	public static void main(String[] args){
		new Son();
	}
}

class Grandpa{}

class Father extends Grandpa{}

class Son extends Father implements Relationship {}

interface Relationship{}