package com.jobghar.command;

import com.webleaf.command.Command;
import com.webleaf.contextobject.ContextObject;

public class PostJobCommand implements Command {
	@Override
	public String process(ContextObject contextObject) {
		String title = null;
		String description = null;

		title = contextObject.getRequestParameter("title");
		description = contextObject.getRequestParameter("description");

		System.out.println("description : " + description);

		// store in database

		contextObject.setAttribute("title", title);

		return "job-posted";
	}

}
