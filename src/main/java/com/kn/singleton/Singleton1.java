package com.kn.singleton;

/**
 * Description:
 *      饿汉模式（立即加载方式，线程安全）
 * 		1、构造函数设置为private，不能随便创建实例，从而避免该类被错误的创建（通过Java反射机制能够实例化构造方法为private的类）
 * 	    2、instance对象必须是private且static的（不是private，安全性无法保证）
 *
 * 	    缺点：
 * 	    静态成员instance，会在类第一次初始化的时候被创建（访问Singleton1.STATUS时）
 * @author kevin
 *
 */
public class Singleton1 {

    public static int STATUS = 1;
	
	private Singleton1() {}

	// 方法1：静态常量实现
	private static Singleton1 instance = new Singleton1();

	// 方法2：静态代码块
	/*static {
	    instance = new Singleton1();
    }*/
	
	public static Singleton1 getInstance() {
		return instance;
	}
}
