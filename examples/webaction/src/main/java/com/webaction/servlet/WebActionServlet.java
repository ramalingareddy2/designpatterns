package com.webaction.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webaction.command.Command;
import com.webaction.exception.CommandConfigNotFoundException;
import com.webaction.exception.LoadConfigFailedException;
import com.webaction.exception.RequestMethodNotAllowedException;
import com.webaction.exception.ViewConfigNotFoundException;
import com.webaction.helper.CommandHelper;
import com.webaction.helper.DispatcherView;

public class WebActionServlet extends HttpServlet {
	private final String COMMAND_CONFIG_LOCATION = "/WEB-INF/command-config.properties";
	private final String VIEW_CONFIG_LOCATION = "/WEB-INF/views.properties";

	private Properties commandConfigProps;
	private Properties viewsProps;

	@Override
	public void init(ServletConfig config) throws ServletException {
		String webRootDir = null;
		File viewConfigFile = null;
		File commandConfigFile = null;
		ServletContext servletContext = null;

		servletContext = config.getServletContext();
		webRootDir = servletContext.getRealPath("/");

		commandConfigFile = new File(webRootDir + COMMAND_CONFIG_LOCATION);
		if (commandConfigFile.exists() == false) {
			throw new CommandConfigNotFoundException(
					"unable to load command-config.properties under /WEB-INF directory");
		}
		viewConfigFile = new File(webRootDir + VIEW_CONFIG_LOCATION);
		if (viewConfigFile.exists() == false) {
			throw new ViewConfigNotFoundException("unable to load view config from /WEB-INF directory");
		}

		try {
			commandConfigProps = new Properties();
			commandConfigProps.load(new FileInputStream(commandConfigFile));
		} catch (IOException e) {
			throw new LoadConfigFailedException("error while loading command-config.properties", e);
		}

		try {
			viewsProps = new Properties();
			viewsProps.load(new FileInputStream(viewConfigFile));
		} catch (IOException e) {
			throw new LoadConfigFailedException("error while loading views.properties", e);
		}
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestUrl = null;
		String httpMethod = null;
		Command command = null;
		String outcome = null;

		requestUrl = req.getServletPath();
		command = CommandHelper.getCommand(requestUrl, commandConfigProps);

		// perform common processing logic
		System.out.println("performing common processing logic that should be applied for all the requests");
		httpMethod = req.getMethod();
		if (httpMethod.equalsIgnoreCase("get") == false && httpMethod.equalsIgnoreCase("post") == false) {
			throw new RequestMethodNotAllowedException("only allowed request methods are GET/POST");
		}
		outcome = command.process(req, resp);
		DispatcherView.dispatch(req, resp, outcome, viewsProps);
	}

}
