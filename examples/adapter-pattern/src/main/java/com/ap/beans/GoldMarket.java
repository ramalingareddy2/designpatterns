package com.ap.beans;

import java.io.IOException;
import java.util.Properties;

public class GoldMarket {
	private Properties props;

	public GoldMarket() throws IOException {
		props = new Properties();
		props.load(this.getClass().getClassLoader().getResourceAsStream("gm-rates.properties"));
	}

	public double getMarketPrice() throws IOException {
		double marketPrice = 0;

		marketPrice = Double.parseDouble(props.getProperty("gold.price"));
		return marketPrice;
	}

	public double buy(double quantity) throws IOException {
		double marketPrice = 0;
		double perGramPrice = 0;

		System.out.println("received buy request for quantity : " + quantity);
		marketPrice = getMarketPrice();
		perGramPrice = marketPrice / 10;

		return quantity * perGramPrice;
	}

	public double sell(double quantity) throws IOException {
		double marketPrice = 0;
		double perGramPrice = 0;
		double valuationAmount = 0;
		double finalExchangeAmount = 0;
		double wastageCharges = 0;

		System.out.println("received sell request for quantity : " + quantity);
		marketPrice = getMarketPrice();
		wastageCharges = Double.parseDouble(props.getProperty("wastage.charges"));
		perGramPrice = marketPrice / 10.0;
		valuationAmount = quantity * perGramPrice;

		finalExchangeAmount = valuationAmount - (valuationAmount * (wastageCharges / 100));
		return finalExchangeAmount;
	}
}
