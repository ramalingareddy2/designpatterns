package com.sp.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.sp.serialization.pattern.VoiceRecognizer;

public class SerializationTest {
	private static final String SER_FILE = "d:/voicerecognizer.ser";

	public static void main(String[] args) {

		/*
		 * VoiceRecognizer voiceRecognizer = VoiceRecognizer.getInstance();
		 * voiceRecognizer.setLevel("High");
		 * 
		 * serialize(voiceRecognizer, SER_FILE);
		 */

		
		  VoiceRecognizer voiceRecognizer1 = deserialize(SER_FILE);
		  voiceRecognizer1.recognize(); VoiceRecognizer voiceRecognizer2 =
		  deserialize(SER_FILE); voiceRecognizer2.recognize();
		 

	}

	public static void serialize(VoiceRecognizer voiceRecognizer, String outFile) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(outFile)));) {
			oos.writeObject(voiceRecognizer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static VoiceRecognizer deserialize(String inFile) {
		VoiceRecognizer voiceRecognizer = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(inFile)));) {
			voiceRecognizer = (VoiceRecognizer) ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return voiceRecognizer;
	}
}
