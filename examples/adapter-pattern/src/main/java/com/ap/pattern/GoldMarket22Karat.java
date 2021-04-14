package com.ap.pattern;

import java.io.IOException;

import com.ap.beans.GoldMarket;

public class GoldMarket22Karat {
	private GoldMarket goldMarket;

	public GoldMarket22Karat() throws IOException {
		goldMarket = new GoldMarket();
	}

	public double getMarketPrice() throws IOException {
		double marketPrice24Karat = 0;
		double marketPrice22Karat = 0;

		marketPrice24Karat = goldMarket.getMarketPrice();
		marketPrice22Karat = (22 / 24.0) * marketPrice24Karat;

		return marketPrice22Karat;
	}

	public double buy(int quantity) throws IOException {
		double quantityIn24Karat = 0;

		quantityIn24Karat = (22 / 24.0) * quantity;
		return goldMarket.buy(quantityIn24Karat);
	}

	public double sell(int quantity) throws IOException {
		double quantityIn24Karat = 0;

		quantityIn24Karat = (22 / 24.0) * quantity;
		return goldMarket.sell(quantityIn24Karat);
	}

}
