package com.webleaf.contextobject.factory;

import com.webleaf.contextobject.ContextObject;
import com.webleaf.contextobject.MapContextObject;

public class ContextObjectFactory {
	public static ContextObject createContextObject(String path) {
		ContextObject contextObject = null;

		contextObject = new MapContextObject();
		return contextObject;
	}
}
