package com.webleaf.contextobject;

import java.util.Map;

public interface ContextObject {
	Map<String, String[]> getRequestParameters();

	String[] getRequestParameterValues(String paramName);

	String getRequestParameter(String paramName);

	void setAttribute(String key, Object value);

	Map<String, Object> getAttributes();

	void setRequestParameters(Map<String, String[]> requestParameters);
}
