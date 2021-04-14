package com.daop.test;

import com.daop.service.StockService;

public class DAOPTest {
	public static void main(String[] args) {
		StockService stockService = new StockService();
		double totalHoldings = stockService.getStockHolding();

		System.out.println("total holdings : " + totalHoldings);
	}

}
