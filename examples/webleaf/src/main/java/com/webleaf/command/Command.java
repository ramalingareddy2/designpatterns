package com.webleaf.command;

import com.webleaf.contextobject.ContextObject;

public interface Command {
	String process(ContextObject contextObject);
}
