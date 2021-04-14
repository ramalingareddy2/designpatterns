package com.webleaf.helper;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webleaf.config.metadata.WebLeafMetadata;
import com.webleaf.exception.DispatcherViewException;

public class DispatcherView {
	public static void dispatch(HttpServletRequest request, HttpServletResponse response, String requestUrl,
			String outcome, WebLeafMetadata webLeafMetadata) {
		String page = null;

		try {
			page = webLeafMetadata.getPage(requestUrl, outcome);
			request.getRequestDispatcher(page).forward(request, response);
		} catch (ServletException | IOException e) {
			throw new DispatcherViewException("error while forwarding to the page : " + page, e);
		}
	}
}
