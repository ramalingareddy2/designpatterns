package com.sp.synclazyinstantiation.runnables;

import com.sp.doublecheck.pattern.VoiceRecognizer;

public class CallerThread implements Runnable {
	@Override
	public void run() {
		VoiceRecognizer voiceRecognizer = VoiceRecognizer.getInstance();
		voiceRecognizer.recognize();
	}
}
