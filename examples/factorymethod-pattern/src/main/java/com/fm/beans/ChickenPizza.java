package com.fm.beans;

public class ChickenPizza implements Pizza {

	@Override
	public void prepareDough() {
		System.out.println("preparing hard and thick dough for chicken pizza");
	}

	@Override
	public void bake() {
		System.out.println("baking chicken");
		System.out.println("applying chiken on the pizza base");
		System.out.println("baking to 900 degrees temparature");
	}

	@Override
	public void box() {
		System.out.println("cutting chicken pizza and placing in red box");
	}

}
