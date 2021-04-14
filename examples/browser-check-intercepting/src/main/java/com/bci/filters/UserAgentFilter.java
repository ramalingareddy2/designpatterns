package com.bci.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserAgentFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String userAgent = null;
		HttpServletRequest httpRequest = null;
		HttpServletResponse httpResponse = null;

		httpRequest = (HttpServletRequest) request;
		httpResponse = (HttpServletResponse) response;
		userAgent = httpRequest.getHeader("User-Agent");

		if (userAgent.contains("Firefox") == false) {
			httpRequest.getRequestDispatcher("/unsupported-browser-error.jsp").forward(httpRequest, httpResponse);
			return;
		}
		chain.doFilter(httpRequest, httpResponse);
	}

}
