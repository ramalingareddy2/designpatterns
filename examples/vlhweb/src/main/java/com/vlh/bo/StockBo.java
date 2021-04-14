package com.vlh.bo;

public class StockBo {
	private String stockName;
	private String manufacturer;
	private double price;

	public StockBo(String stockName, String manufacturer, double price) {
		this.stockName = stockName;
		this.manufacturer = manufacturer;
		this.price = price;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
