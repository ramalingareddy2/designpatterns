package com.fp.pattern;

import java.io.IOException;
import java.util.Properties;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import com.fp.beans.Job;
import com.fp.beans.JobConfig;

public class JobFactory {
	public static Job newJob(String algorithm) throws IOException {
		String jobConfigFile = null;
		JobConfig jobConfig = null;
		Properties props = null;
		Job job = null;

		jobConfigFile = algorithm + "-job-config.json";
		/*
		 * props = new Properties();
		 * props.load(JobFactory.class.getClassLoader().getResourceAsStream(
		 * jobConfigFile));
		 */
		JsonReader jsonReader = Json.createReader(JobFactory.class.getClassLoader().getResourceAsStream(jobConfigFile));
		JsonObject jsonObject = jsonReader.readObject();

		jobConfig = new JobConfig();
		/*
		 * jobConfig.setExtensionType(props.getProperty("extensionType"));
		 * jobConfig.setThreads(Integer.parseInt(props.getProperty("threads")));
		 * jobConfig.setBatchSize(Integer.parseInt(props.getProperty("batchSize")));
		 */
		jobConfig.setExtensionType(jsonObject.getString("extensionType"));
		jobConfig.setThreads(jsonObject.getInt("threads"));
		jobConfig.setBatchSize(jsonObject.getInt("batchSize"));

		job = new Job(jobConfig, algorithm);
		return job;
	}
}
