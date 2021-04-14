package com.webleaf.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webleaf.config.manager.WebLeafConfigManager;
import com.webleaf.config.metadata.WebLeafMetadata;
import com.webleaf.controller.WebLeafRequestProcessor;

public class WebLeafServlet extends HttpServlet {
	private final String WEB_LEAF_CONFIG_LOCATION = "/WEB-INF/webleaf-config.xml";
	private WebLeafMetadata webLeafMetadata;
	private WebLeafRequestProcessor webLeafRequestProcessor;

	@Override
	public void init(ServletConfig config) throws ServletException {
		String configLocation = null;
		String webRootLocation = null;
		ServletContext servletContext = null;

		servletContext = config.getServletContext();
		webRootLocation = servletContext.getRealPath("/");
		configLocation = webRootLocation + WEB_LEAF_CONFIG_LOCATION;

		webLeafMetadata = WebLeafConfigManager.loadWebLeafMetadata(configLocation);
		webLeafRequestProcessor = new WebLeafRequestProcessor();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// apply common processing logic
		webLeafRequestProcessor.process(req, resp, webLeafMetadata);
		// apply post processing
	}

}
