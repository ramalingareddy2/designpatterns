package com.webleaf.helper;

import com.webleaf.command.Command;
import com.webleaf.config.metadata.WebLeafMetadata;
import com.webleaf.exception.CommandCreationFailedException;

public class CommandHelper {
	public static Command getCommand(String requestUrl, WebLeafMetadata webLeafMetadata) {
		Command command = null;
		String commandClassname = null;

		try {
			commandClassname = webLeafMetadata.getCommandClass(requestUrl);
			command = (Command) Class.forName(commandClassname).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new CommandCreationFailedException(
					"error while creating the object of commandClass: " + commandClassname, e);
		}
		return command;
	}
}
