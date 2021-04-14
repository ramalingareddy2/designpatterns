package com.fp.test;

import java.io.IOException;

import com.fp.beans.JobManager;

public class FPTest {
	public static void main(String[] args) throws IOException {
		JobManager jobManager = new JobManager();
		jobManager.launch("sorting");
	}
}
