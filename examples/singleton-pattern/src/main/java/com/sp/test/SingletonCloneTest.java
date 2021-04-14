package com.sp.test;

import com.sp.clone.pattern.VoiceRecognizer;

public class SingletonCloneTest {
	public static void main(String[] args) throws CloneNotSupportedException {
		VoiceRecognizer voiceRecognizer1 = VoiceRecognizer.getInstance();
		voiceRecognizer1.recognize();
		VoiceRecognizer voiceRecognizer2 = (VoiceRecognizer) voiceRecognizer1.clone();
		voiceRecognizer2.recognize();
	}
}
