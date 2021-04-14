package com.sp.serialization.pattern;

abstract public class VoiceRecognizer extends Audit {
	private static final long serialVersionUID = -6632069317113700309L;
	private static VoiceRecognizer instance;
	private String level;

	private VoiceRecognizer() throws InstantiationException {
		if (instance != null) {
			throw new InstantiationException("object already exists!");
		}
	}

	public static VoiceRecognizer getInstance() throws InstantiationException {
		if (instance == null) {
			synchronized (VoiceRecognizer.class) {
				if (instance == null) {
					instance = new VoiceRecognizer() {
					};
				}
			}
		}
		return instance;
	}

	public Object readResolve() {
		if (instance == null) {
			instance = this;
		}
		return instance;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public void recognize() {
		System.out.println("voice recognizer : " + this.hashCode() + "is recognizing with level : " + this.level);
	}

}
