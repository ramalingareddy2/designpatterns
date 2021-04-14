package com.ser.beans;

import java.io.Serializable;

public class InternalAccount implements Serializable {
	private static final long serialVersionUID = 215449407952615746L;
	private int accountNo;
	private String accountHolderName;
	private int accountType;
	private double balance;

	public Object readResolve() {
		Account account = null;
		System.out.println("readResolve()");

		account = new Account();
		account.setAccountNo(this.getAccountNo());
		account.setAccountHolderName(this.getAccountHolderName());
		account.setBalance(this.getBalance());

		switch (this.getAccountType()) {
		case 1:
			account.setAccountType("savings");
			break;
		case 2:
			account.setAccountType("current");
			break;
		case 3:
			account.setAccountType("nre");
			break;
		case 4:
			account.setAccountType("ngo");
			break;
		case 5:
			account.setAccountType("corporate");
			break;
		}

		return account;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public int getAccountType() {
		return accountType;
	}

	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
