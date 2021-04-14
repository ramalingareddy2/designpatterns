package com.webleaf.contextobject;

import java.util.HashMap;
import java.util.Map;

public class MapContextObject implements ContextObject {
	private Map<String, String[]> requestParametersMap;
	private Map<String, Object> responseAttributesMap;

	public MapContextObject() {
		requestParametersMap = new HashMap<String, String[]>();
		responseAttributesMap = new HashMap<String, Object>();
	}

	@Override
	public Map<String, String[]> getRequestParameters() {
		return requestParametersMap;
	}

	@Override
	public String[] getRequestParameterValues(String paramName) {
		return requestParametersMap.get(paramName);
	}

	@Override
	public String getRequestParameter(String paramName) {
		if (requestParametersMap.containsKey(paramName)) {
			return requestParametersMap.get(paramName)[0];
		}
		return null;
	}

	@Override
	public void setAttribute(String key, Object value) {
		responseAttributesMap.put(key, value);
	}

	@Override
	public Map<String, Object> getAttributes() {
		return responseAttributesMap;
	}

	public void setRequestParameters(Map<String, String[]> requestParameters) {
		this.requestParametersMap = requestParameters;
	}
}
