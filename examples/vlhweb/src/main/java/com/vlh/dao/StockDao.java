package com.vlh.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vlh.bo.StockBo;
import com.vlh.helper.ConnectionFactory;

public class StockDao {

	public int getNoOfStocks() {
		ResultSet rs = null;
		int count = 0;

		try (Connection con = ConnectionFactory.newConnection(); Statement stmt = con.createStatement();) {
			rs = stmt.executeQuery("select count(1) from stock");
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			throw new RuntimeException("error in getting stocks by pagniation", e);
		}
		return count;
	}

	public List<StockBo> getStocksByPagination(int pageNo, int pageSize) {
		List<StockBo> bos = null;
		ResultSet rs = null;
		StockBo bo = null;

		int startIndex = 0;
		int endIndex = 0;
		int index = 1;

		try (Connection con = ConnectionFactory.newConnection(); Statement stmt = con.createStatement();) {
			rs = stmt.executeQuery("select stock_nm, manufacturer_nm, amount from stock order by stock_nm asc");
			bos = new ArrayList<>();
			startIndex = ((pageNo - 1) * pageSize) + 1;
			endIndex = pageNo * pageSize;

			while (rs.next() && index <= endIndex) {
				if (index >= startIndex) {
					bo = new StockBo(rs.getString(1), rs.getString(2), rs.getDouble(3));
					bos.add(bo);
				}
				index++;
			}
		} catch (Exception e) {
			throw new RuntimeException("error in getting stocks by pagniation", e);
		}

		return bos;
	}

}
