package com.fm.stores;

import com.fm.beans.Pizza;
import com.fm.pattern.ChennaiPizzaFactory;
import com.fm.pattern.PizzaFactory;

public class ChennaiPizaStore {
	public Pizza orderPizza(String pizzaType) {
		Pizza pizza = null;
		PizzaFactory pizzaFactory = null;

		pizzaFactory = new ChennaiPizzaFactory();
		pizza = pizzaFactory.newPizza(pizzaType);

		return pizza;
	}
}
