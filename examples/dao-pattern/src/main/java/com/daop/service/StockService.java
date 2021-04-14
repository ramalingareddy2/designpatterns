package com.daop.service;

import java.util.Date;
import java.util.List;

import com.daop.bo.StockBo;
import com.daop.dao.StockDao;
import com.daop.dao.StockDaoImpl;

public class StockService {
	private StockDao stockDao;

	public StockService() {
		stockDao = new StockDaoImpl();
	}

	public double getStockHolding() {
		List<StockBo> stockBos = null;
		Date today = null;
		double totalStockCost = 0;

		today = new Date();
		stockBos = stockDao.getStock();
		for (StockBo bo : stockBos) {
			if (today.compareTo(bo.getExpiryDate()) < 0) {
				totalStockCost += bo.getAmount();
			}
		}

		return totalStockCost;
	}
}
