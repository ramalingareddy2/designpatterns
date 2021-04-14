package com.webleaf.mapper;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.webleaf.contextobject.ContextObject;

public class HttpMapper implements Mapper {

	@Override
	public void extractDataAndPopulate(Object protocolHandler, ContextObject contextObject) {
		HttpServletRequest httpServletRequest = null;
		Map<String, String[]> requestParametersMap = null;

		httpServletRequest = (HttpServletRequest) protocolHandler;
		requestParametersMap = httpServletRequest.getParameterMap();
		contextObject.setRequestParameters(requestParametersMap);
	}

	@Override
	public void bindData(Object protocolHandler, ContextObject contextObject) {
		final HttpServletRequest httpServletRequest = (HttpServletRequest) protocolHandler;

		contextObject.getAttributes().forEach((attributeName, attributeValue) -> {
			httpServletRequest.setAttribute(attributeName, attributeValue);
		});
	}

}
