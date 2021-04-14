package com.ser.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.ser.beans.Account;

public class SerTest {
	private final static String SER_FILE = "d:\\account.ser";

	public static void main(String[] args) {

		/*
		 * Account account = new Account(); account.setAccountNo(102);
		 * account.setAccountHolderName("Williams"); account.setAccountType("savings");
		 * account.setBalance(1000);
		 * 
		 * serialize(account, SER_FILE);
		 */

		Account account = deserialize(SER_FILE);
		System.out.println(account.getAccountNo());
	}

	public static void serialize(Account account, String outFile) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(outFile)));) {
			oos.writeObject(account);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Account deserialize(String inFile) {
		Account account = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(inFile)));) {
			account = (Account) ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return account;
	}
}
