package com.sp.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.sp.serialization.pattern.VoiceRecognizer;

public class SPReflectionTest {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		VoiceRecognizer voiceRecognizer = VoiceRecognizer.getInstance();
		
		
		
		Constructor<?> defaultConstructor = VoiceRecognizer.class.getDeclaredConstructor(new Class<?>[] {});
		defaultConstructor.setAccessible(true);
		voiceRecognizer.recognize();
		
		VoiceRecognizer voiceRecognizer2 = (VoiceRecognizer) defaultConstructor.newInstance(null);

		
		voiceRecognizer2.recognize();
	}
}
