package com.daop.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.daop.bo.StockBo;
import com.daop.exception.GenericException;
import com.daop.helper.ConnectionFactory;

/**
 * Dao is a class which contains only Data Access logic or persistency logic, it
 * helps us in separating the persistency aspects of the application from other
 * classes of our application
 * 
 * @author Sriman
 *
 */
public class StockDaoImpl implements StockDao {
	@Override
	public List<StockBo> getStock() {
		ResultSet rs = null;
		StockBo stockBo = null;
		List<StockBo> stockBos = null;

		try (Connection con = ConnectionFactory.newConnection(); Statement stmt = con.createStatement();) {
			rs = stmt.executeQuery("select stock_no, stock_nm, manufacturer_nm, expiry_date, amount from stock");
			stockBos = new ArrayList<StockBo>();
			while (rs.next()) {
				stockBo = new StockBo(rs.getInt(1), rs.getString(2), rs.getString(3),
						new java.util.Date(rs.getDate(4).getTime()), rs.getFloat(5));
				stockBos.add(stockBo);
			}
		} catch (SQLException e) {
			throw new GenericException(e);
		}
		return stockBos;
	}

}
