package com.webleaf.config.metadata;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.webleaf.config.Command;
import com.webleaf.config.Outcome;
import com.webleaf.exception.CommandNotFoundException;

public class WebLeafMetadata {
	private Map<String, Command> commandMap;

	public WebLeafMetadata(Map<String, Command> commandMap) {
		this.commandMap = commandMap;
	}

	public String getCommandClass(String path) {
		String commandClass = null;
		Command command = null;

		if (commandMap.containsKey(path) == false) {
			throw new CommandNotFoundException("Command Class not found for the path : " + path);
		}
		command = commandMap.get(path);
		commandClass = command.getCommandClass();

		return commandClass;
	}

	public String getPage(String path, String outcome) {
		String page = null;
		Command command = null;
		List<Outcome> outcomes = null;

		if (commandMap.containsKey(path) == false) {
			throw new CommandNotFoundException("Command Class not found for the path : " + path);
		}
		command = commandMap.get(path);
		outcomes = command.getOutcome();

		page = outcomes.stream().filter(oc -> {
			return oc.getName().equals(outcome);
		}).collect(Collectors.toList()).get(0).getPage();
		return page;
	}

}










