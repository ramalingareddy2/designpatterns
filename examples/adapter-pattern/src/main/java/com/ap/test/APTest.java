package com.ap.test;

import java.io.IOException;

import com.ap.beans.RetailStore;

public class APTest {
	public static void main(String[] args) throws IOException {
		RetailStore retailStore = new RetailStore();
		//double marketprice = retailStore.getOrnamentalGoldPrice();
		//System.out.println("ornamental 10g gold price : " + marketprice);
		double invoiceAmount = retailStore.sellOrnamentalGold(16);
		System.out.println("invoice amount : " +invoiceAmount);
	}
}
