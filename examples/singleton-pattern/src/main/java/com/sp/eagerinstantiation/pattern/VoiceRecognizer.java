package com.sp.eagerinstantiation.pattern;

public class VoiceRecognizer {
	// create the object and assign to static variable of the class, so that it
	// would be initialized only once thus only one object will be created
	private static VoiceRecognizer instance = new VoiceRecognizer();

	private VoiceRecognizer() {
	}

	public void recognize() {
		System.out.println("recognizer : " + this.hashCode() + " is processing voice");
	}

	public static VoiceRecognizer getInstance() {
		return instance;
	}

}
