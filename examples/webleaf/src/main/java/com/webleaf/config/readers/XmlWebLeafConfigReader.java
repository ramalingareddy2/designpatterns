package com.webleaf.config.readers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.webleaf.config.Command;
import com.webleaf.config.WebLeafConfig;
import com.webleaf.config.metadata.WebLeafMetadata;
import com.webleaf.exception.WebLeafConfigException;

public class XmlWebLeafConfigReader implements WebLeafConfigReader {
	@SuppressWarnings("unchecked")
	@Override
	public WebLeafMetadata buildWebLeafConfig(String location) {
		JAXBContext jContext = null;
		Unmarshaller unmarshaller = null;
		WebLeafConfig webLeafConfig = null;
		WebLeafMetadata webLeafMetadata = null;
		Map<String, Command> commandMap = null;
		JAXBElement<WebLeafConfig> jaxbElement = null;

		try {
			jContext = JAXBContext.newInstance("com.webleaf.config");
			unmarshaller = jContext.createUnmarshaller();
			jaxbElement = (JAXBElement<WebLeafConfig>) unmarshaller.unmarshal(new FileInputStream(new File(location)));
			webLeafConfig = jaxbElement.getValue();

			commandMap = new HashMap<String, Command>();
			for (Command command : webLeafConfig.getCommandConfigs().getCommand()) {
				commandMap.put(command.getPath(), command);
			}
			webLeafMetadata = new WebLeafMetadata(commandMap);

		} catch (JAXBException | FileNotFoundException e) {
			throw new WebLeafConfigException("failed in loading the webleaf configuration", e);
		}

		return webLeafMetadata;
	}

}
