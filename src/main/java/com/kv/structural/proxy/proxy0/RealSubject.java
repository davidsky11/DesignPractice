package com.kv.structural.proxy.proxy0;

// 被代理类
public class RealSubject implements Subject {

	@Override
	public void request() {
		System.out.println("message from real object.");
	}

}
