package com.woodart.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webaction.command.Command;

public class AddStockCommand implements Command {
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		String stockName = null;
		
		stockName = request.getParameter("stockName");
		
		request.setAttribute("stock", stockName);

		return "stock-added";
	}
}
