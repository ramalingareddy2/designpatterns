package com.webleaf.mapper;

import com.webleaf.contextobject.ContextObject;

public interface Mapper {
	void extractDataAndPopulate(Object protocolHandler, ContextObject contextObject);

	void bindData(Object protocolHandler, ContextObject contextObject);
}
