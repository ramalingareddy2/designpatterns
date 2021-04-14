package com.webaction.helper;

import java.util.Properties;

import com.webaction.command.Command;
import com.webaction.exception.CommandCreationFailedException;
import com.webaction.exception.CommandNotFoundException;

public class CommandHelper {
	public static Command getCommand(String requestUrl, Properties commandConfigProps) {
		Command command = null;
		String commandClassname = null;

		if (commandConfigProps.containsKey(requestUrl) == false) {
			throw new CommandNotFoundException("unable to find a commandClass for the requestUrl : " + requestUrl);
		}
		commandClassname = commandConfigProps.getProperty(requestUrl);
		try {
			command = (Command) Class.forName(commandClassname).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new CommandCreationFailedException(
					"Failed in creating the object for command class : " + commandClassname, e);
		}

		return command;
	}
}
