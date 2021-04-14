package com.sp.lazyinstantiation.pattern;

public class VoiceRecognizer {
	private static VoiceRecognizer instance;

	static {
		System.out.println("loading class...");
	}

	private VoiceRecognizer() {
	}

	public static VoiceRecognizer getInstance() {
		System.out.println("getInstance() executing");
		if (instance == null) { // create only when it has not yet instantiated
			System.out.println("creating object of voice recognizer");
			instance = new VoiceRecognizer();
		}
		return instance;
	}

	public void recognize() {
		System.out.println("Voice Recognizer : " + this.hashCode() + " is recognizing lazily");
	}
}
