package com.fp.beans;

public class Job {
	private JobConfig jobConfig;
	private String algorithm;

	public Job(JobConfig jobConfig, String algorithm) {
		this.jobConfig = jobConfig;
		this.algorithm = algorithm;
	}

	public int execute() {
		System.out.println("executing job with algorithm : " + algorithm + " with job config : " + jobConfig);
		return 0;
	}

	public JobConfig getJobConfig() {
		return jobConfig;
	}

	public void setJobConfig(JobConfig jobConfig) {
		this.jobConfig = jobConfig;
	}

}
