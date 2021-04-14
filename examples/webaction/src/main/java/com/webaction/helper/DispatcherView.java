package com.webaction.helper;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webaction.exception.DispatchFailedException;
import com.webaction.exception.ViewNotFoundException;

public class DispatcherView {
	public static void dispatch(HttpServletRequest req, HttpServletResponse resp, String outcome, Properties viewsProperties) {
		String page = null;

		if (viewsProperties.containsKey(outcome) == false) {
			throw new ViewNotFoundException("unable to identify the view page for the outcome : " + outcome);
		}

		page = viewsProperties.getProperty(outcome);
		try {
			req.getRequestDispatcher(page).forward(req, resp);
		} catch (ServletException | IOException e) {
			throw new DispatchFailedException("Failed while dispatching the view : " + page, e);
		}
	}
}
