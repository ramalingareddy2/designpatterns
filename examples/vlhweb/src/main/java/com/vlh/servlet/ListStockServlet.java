package com.vlh.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vlh.dto.StockDto;
import com.vlh.helper.ObjectFactory;
import com.vlh.service.StockService;

@WebServlet(urlPatterns = { "/stocks" })
public class ListStockServlet extends HttpServlet {
	private StockService stockService;
	private final int pageSize = 3;

	@Override
	public void init() throws ServletException {
		stockService = ObjectFactory.getObject(StockService.class);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<StockDto> stocks = null;
		int totalRecords = 0;
		String action = null;
		int totalPages = 0;
		int pageNo = 1;

		action = req.getParameter("action");
		if (action == null) {
			pageNo = 1;
		} else {
			if (action.equals("next")) {
				pageNo = Integer.parseInt(req.getParameter("cPageNo"));
				pageNo = pageNo + 1;
			} else if (action.equals("prev")) {
				pageNo = Integer.parseInt(req.getParameter("cPageNo"));
				pageNo = pageNo - 1;
			}
		}

		stocks = stockService.getStocksByPagination(pageNo, pageSize);
		totalRecords = stockService.getNoOfStocks();
		totalPages = (int) (Math.ceil((double) totalRecords / pageSize));
		req.setAttribute("stocks", stocks);
		req.setAttribute("totalPages", totalPages);
		req.setAttribute("pageNo", pageNo);

		req.getRequestDispatcher("/stocks.jsp").forward(req, resp);
	}

}
