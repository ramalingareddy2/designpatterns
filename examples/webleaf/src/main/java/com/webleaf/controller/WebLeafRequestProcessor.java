package com.webleaf.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webleaf.command.Command;
import com.webleaf.config.metadata.WebLeafMetadata;
import com.webleaf.contextobject.ContextObject;
import com.webleaf.contextobject.factory.ContextObjectFactory;
import com.webleaf.helper.CommandHelper;
import com.webleaf.helper.DispatcherView;
import com.webleaf.mapper.Mapper;
import com.webleaf.mapper.factory.MapperFactory;

// ApplicationController
public class WebLeafRequestProcessor {
	public void process(HttpServletRequest request, HttpServletResponse response, WebLeafMetadata webLeafMetadata) {
		ContextObject contextObject = null;
		String requestUrl = null;
		Command command = null;
		Mapper mapper = null;
		String outcome = null;

		requestUrl = request.getServletPath();
		contextObject = ContextObjectFactory.createContextObject(requestUrl);

		mapper = MapperFactory.createMapper("http");
		mapper.extractDataAndPopulate(request, contextObject);

		command = CommandHelper.getCommand(requestUrl, webLeafMetadata);
		outcome = command.process(contextObject);
		
		mapper.bindData(request, contextObject);
		DispatcherView.dispatch(request, response, requestUrl, outcome, webLeafMetadata);
	}
}
