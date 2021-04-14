package com.fm.pattern;

import com.fm.beans.Pizza;

public abstract class PizzaFactory {
	final public Pizza newPizza(String pizzaType) {
		Pizza pizza = null;

		pizza = createPizza(pizzaType);

		System.out.println("applying standard preparation process in creating pizzas");
		pizza.prepareDough();
		pizza.bake();
		pizza.box();

		return pizza;
	}

	abstract protected Pizza createPizza(String pizzaType);
}
