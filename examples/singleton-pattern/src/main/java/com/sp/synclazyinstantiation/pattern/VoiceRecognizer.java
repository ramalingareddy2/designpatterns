package com.sp.synclazyinstantiation.pattern;

public class VoiceRecognizer {
	private static VoiceRecognizer instance;

	private VoiceRecognizer() {
		// no code, but still required leave it
	}

	/**
	 * Don't let multiple threads to simultaneously create the object of the class
	 * 
	 * @return
	 */
	public synchronized static VoiceRecognizer getInstance() {
		if (instance == null) {
			try {
				Thread.sleep(100L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance = new VoiceRecognizer();
		}
		return instance;
	}

	public void recognize() {
		System.out.println("voice recognizer : " + this.hashCode() + " is recognizing...");
	}
}
