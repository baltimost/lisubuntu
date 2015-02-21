/*
* @(#)ConventionExample.java 1.0 2004-6-6.
*
* Copyright (c) 2004 Global 3D Studio
* All Rights Reserved.
*/

package g3ds.joop.ch5;

import javax.swing.*;

/**
* ConventionExample类用来描述Java语言中使用的一些规范。
*
* @version 1.0 18 2004-6-6
* @author F.Z. Lee
*/
public class ConventionExample extends JFrame {
	/* 可以在此添加有关类实现的一些相关的注释 */
	
	/** 有关类变量classVar1的文档注释*/
	public static int classVar1;
	
	/**
	 * 有关类变量classVar2 的文档注释
	 * 注释可以多行表示，并可包含一些HTML标识符号
	 */
	private static Object classVar2;
	
	/** 有关实例变量instanceVar1的文档注释 */
	public Object instanceVar1;
	
	/** 有关实例变量instanceVar2的文档注释 */
	protected int instanceVar2;
	
	/** 有关实例变量instanceVar3的文档注释 */
	private Object[] instanceVar3;
	
	/**
	 * 有关构造方法ConventionExample的文档注释
	 */
	public ConventionExample() {
		// 构造方法的具体实现...
	}
	
	/**
	 * 有关doSomething方法 的文档注释
	 */
	public void doSomething() {
		// 方法的具体实现...
	}
	
	/**
	 * 有关doSomethingElse 方法的文档注释
	 * @param 行参someParam的用途描述
	 */
	public void doSomethingElse(Object someParam) {
		// 方法的具体实现...
	}
}
