package com.webaction.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	String process(HttpServletRequest request, HttpServletResponse response);
}
