package com.fm.pattern;

import com.fm.beans.ChickenPizza;
import com.fm.beans.CornPizza;
import com.fm.beans.Pizza;

public class BanglorePizzaFactory extends PizzaFactory {

	@Override
	protected Pizza createPizza(String pizzaType) {
		Pizza pizza = null;

		System.out.println("banglore pizza factory is creating pizza");
		if (pizzaType.equals("chicken")) {
			pizza = new ChickenPizza();
		} else if (pizzaType.equals("corn")) {
			pizza = new CornPizza();
		}

		return pizza;
	}

}
