package com.fp.beans;

import java.io.IOException;

import com.fp.pattern.JobFactory;

public class JobManager {
	public void launch(String algorithm) throws IOException {
		Job job = null;

		job = JobFactory.newJob(algorithm);
		int jobStatus = job.execute();

		System.out.println("job status : " + jobStatus);
	}
}
