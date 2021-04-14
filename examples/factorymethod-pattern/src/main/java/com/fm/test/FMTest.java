package com.fm.test;

import com.fm.beans.Pizza;
import com.fm.stores.ChennaiPizaStore;

public class FMTest {
	public static void main(String[] args) {
		ChennaiPizaStore chennaiPizaStore = new ChennaiPizaStore();
		Pizza pizza = chennaiPizaStore.orderPizza("chicken");
		System.out.println("pizza : " + pizza.getClass().getName());
	}
}
