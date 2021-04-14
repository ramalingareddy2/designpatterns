package com.ap.beans;

import java.io.IOException;

import com.ap.pattern.GoldMarket22Karat;

public class RetailStore {
	private GoldMarket22Karat goldMarket22Karat;

	public RetailStore() throws IOException {
		goldMarket22Karat = new GoldMarket22Karat();
	}

	public double getOrnamentalGoldPrice() throws IOException {
		return goldMarket22Karat.getMarketPrice();
	}

	public double buyOrnamentalGold(int quantity) throws IOException {
		return goldMarket22Karat.buy(quantity);
	}

	public double sellOrnamentalGold(int quantity) throws IOException {
		return goldMarket22Karat.sell(quantity);
	}
}
