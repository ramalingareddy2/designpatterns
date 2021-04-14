package com.vlh.service;

import java.util.List;
import java.util.stream.Collectors;

import com.vlh.dao.StockDao;
import com.vlh.dto.StockDto;
import com.vlh.helper.ObjectFactory;

public class StockService {
	private StockDao stockDao;

	public StockService() {
		stockDao = ObjectFactory.getObject(StockDao.class);
	}

	public int getNoOfStocks() {
		return stockDao.getNoOfStocks();
	}

	public List<StockDto> getStocksByPagination(int pageNo, int pageSize) {
		return stockDao.getStocksByPagination(pageNo, pageSize).stream().map(bo -> {
			StockDto dto = new StockDto(bo.getStockName(), bo.getManufacturer(), bo.getPrice());
			return dto;
		}).collect(Collectors.toList());
	}
}
