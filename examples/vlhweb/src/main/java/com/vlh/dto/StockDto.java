package com.vlh.dto;

public class StockDto {
	private String stockName;
	private String manufacturer;
	private double price;

	public StockDto(String stockName, String manufacturer, double price) {
		super();
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
