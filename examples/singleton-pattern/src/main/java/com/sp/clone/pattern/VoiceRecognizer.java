package com.sp.clone.pattern;

public class VoiceRecognizer extends Audit implements Cloneable {
	private static VoiceRecognizer instance;

	private VoiceRecognizer() {
	}

	public static VoiceRecognizer getInstance() {
		if (instance == null) {
			synchronized (VoiceRecognizer.class) {
				if (instance == null) {
					instance = new VoiceRecognizer();
				}
			}
		}
		return instance;
	}

	public void recognize() throws CloneNotSupportedException {
		System.out.println("voice recognizer : " + this.hashCode() + " is recognizing...");
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}
