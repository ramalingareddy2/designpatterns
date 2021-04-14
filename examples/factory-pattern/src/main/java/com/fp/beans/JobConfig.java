package com.fp.beans;

public class JobConfig {
	private String extensionType;
	private int threads;
	private int batchSize;

	public String getExtensionType() {
		return extensionType;
	}

	public void setExtensionType(String extensionType) {
		this.extensionType = extensionType;
	}

	public int getThreads() {
		return threads;
	}

	public void setThreads(int threads) {
		this.threads = threads;
	}

	public int getBatchSize() {
		return batchSize;
	}

	public void setBatchSize(int batchSize) {
		this.batchSize = batchSize;
	}

	@Override
	public String toString() {
		return "[extensionType=" + extensionType + ", threads=" + threads + ", batchSize=" + batchSize + "]";
	}

}
