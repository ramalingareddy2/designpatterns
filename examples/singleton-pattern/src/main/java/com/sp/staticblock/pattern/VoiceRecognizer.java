package com.sp.staticblock.pattern;

public class VoiceRecognizer {
	// let us store the object we have created in static-variable so that we have
	// only one copy of the object for the Class
	private static VoiceRecognizer instance;// if we dont have any initialization logic to be peformed then directly
											// instantitiate the object and assign it
	private static String sensitivityLevel;
	// Normal, Less Sensitive, High Sensitive

	static {
		sensitivityLevel = "Normal";
		instance = new VoiceRecognizer();
	}

	private VoiceRecognizer() {
	}

	public static VoiceRecognizer getInstance() {
		return instance;
	}

	public void recognize() {
		System.out.println("voice recognizer : " + this.hashCode() + " is recognizing with sensitivity level : "
				+ sensitivityLevel);
	}
} 
