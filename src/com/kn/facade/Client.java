package com.kn.facade;

public class Client {

	private Facade facade;
	
	public Client(Facade f) {
		this.facade = f;
	}
	
	public void doSomething() {
		facade.doThat();
	}
}
