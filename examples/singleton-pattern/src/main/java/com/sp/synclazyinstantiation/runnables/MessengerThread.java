package com.sp.synclazyinstantiation.runnables;

import com.sp.doublecheck.pattern.VoiceRecognizer;

public class MessengerThread implements Runnable {

	@Override
	public void run() {
		VoiceRecognizer voiceRecognizer = VoiceRecognizer.getInstance();
		voiceRecognizer.recognize();
	}

}
