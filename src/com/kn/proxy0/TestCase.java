package com.kn.proxy0;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

// 测试用例
public class TestCase {

	@Test
	public void test0() {
		Subject s = new ProxySubject();
		s.request();
	}
	
	@Test
	public void test1() {
		Object o = Proxy.newProxyInstance(
				TestCase.class.getClassLoader(), 
				new Class<?>[]{Subject.class}, 
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						System.out.println("This is the proxy for method : " + method.getName());
						return null;
					}
				});
		Subject s = (Subject) o;
		s.request();
	}
	
}
