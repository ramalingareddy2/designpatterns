package com.daop.bo;

import java.util.Date;

/**
 * Business objects are used for storing the data so, that it will be used for
 * performing business operation
 * 
 * @author Sriman
 *
 */
public class StockBo {
	protected int stockNo;
	protected String stockName;
	protected String manufacturer;
	protected Date expiryDate;
	protected double amount;

	public StockBo(int stockNo, String stockName, String manufacturer, Date expiryDate, double amount) {
		this.stockNo = stockNo;
		this.stockName = stockName;
		this.manufacturer = manufacturer;
		this.expiryDate = expiryDate;
		this.amount = amount;
	}

	public int getStockNo() {
		return stockNo;
	}

	public void setStockNo(int stockNo) {
		this.stockNo = stockNo;
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

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
