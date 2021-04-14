package com.webleaf.config.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

import com.webleaf.config.metadata.WebLeafMetadata;
import com.webleaf.config.readers.WebLeafConfigReader;
import com.webleaf.config.readers.XmlWebLeafConfigReader;
import com.webleaf.exception.WebLeafConfigException;

public class WebLeafConfigManager {

	public static WebLeafMetadata loadWebLeafMetadata(String location) {
		Schema schema = null;
		Validator validator = null;
		SchemaFactory schemaFactory = null;
		WebLeafMetadata webLeafMetadata = null;
		WebLeafConfigReader webLeafConfigReader = null;

		if (location != null) {
			if (location.endsWith(".xml")) {
				// validate the xml
				try {
					schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
					schema = schemaFactory.newSchema(WebLeafConfigManager.class.getClassLoader()
							.getResource("META-INF/config/webleaf-config.xsd"));
					validator = schema.newValidator();
					validator.validate(new StreamSource(new FileInputStream(new File(location))));
				} catch (SAXException | IOException e) {
					throw new WebLeafConfigException("error while validating the webleaf configuration", e);
				}
				webLeafConfigReader = new XmlWebLeafConfigReader();
				webLeafMetadata = webLeafConfigReader.buildWebLeafConfig(location);
			}
		}

		return webLeafMetadata;
	}
}
