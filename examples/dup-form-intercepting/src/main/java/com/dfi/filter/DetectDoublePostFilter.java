package com.dfi.filter;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DetectDoublePostFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = null;
		HttpServletResponse httpResponse = null;
		HttpSession httpSession = null;
		String serverToken = null;
		String clientToken = null;
		String token = null;

		httpRequest = (HttpServletRequest) request;
		httpResponse = (HttpServletResponse) response;

		httpSession = httpRequest.getSession(false);
		if (httpSession != null) {
			if (httpRequest.getMethod().equalsIgnoreCase("post")) {
				clientToken = httpRequest.getParameter("clientToken");
				serverToken = (String) httpSession.getAttribute("serverToken");
				if (clientToken.equals(serverToken) == false) {
					httpSession.invalidate();
					httpResponse.sendRedirect("duplicate-form-submission-error.jsp");
					return;
				}
			}
		}
		httpSession = httpRequest.getSession();
		token = UUID.randomUUID().toString();
		httpSession.setAttribute("serverToken", token);
		httpRequest.setAttribute("token", token);
		chain.doFilter(request, response);
	}

}
