package com.kv.structural.bridge;

public class Street extends AbstractRoad {

	public void run() {
		super.run();
		aCar.run();
		System.out.println("在市区街道行驶");
	}
}
