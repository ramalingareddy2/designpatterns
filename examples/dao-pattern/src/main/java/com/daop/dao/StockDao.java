package com.daop.dao;

import java.util.List;

import com.daop.bo.StockBo;

public interface StockDao {
	List<StockBo> getStock();
}
