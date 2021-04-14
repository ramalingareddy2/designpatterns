package com.fm.beans;

public class CornPizza implements Pizza {

	@Override
	public void prepareDough() {
		System.out.println("preparing dough for corn pizza of medium base");
	}

	@Override
	public void bake() {
		System.out.println("bake the pizza base and apply corn on it");
	}

	@Override
	public void box() {
		System.out.println("cut the corn pizza and place in green box");
	}

}
