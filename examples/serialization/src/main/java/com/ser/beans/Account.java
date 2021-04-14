package com.ser.beans;

import java.io.Serializable;

public class Account implements Serializable {
	private static final long serialVersionUID = -1813276239629783202L;
	private int accountNo;
	private String accountHolderName;
	private String accountType;
	private double balance;

	/**
	 * Instance method
	 * 
	 * @return
	 */
	public Object writeReplace() {
		System.out.println("writeReplace()");
		InternalAccount internalAccount = null;

		internalAccount = new InternalAccount();
		internalAccount.setAccountNo(this.getAccountNo());
		internalAccount.setAccountHolderName(this.getAccountHolderName());
		internalAccount.setBalance(this.getBalance());

		switch (this.getAccountType()) {
		case "savings":
			internalAccount.setAccountType(1);
			break;
		case "current":
			internalAccount.setAccountType(2);
			break;
		case "nre":
			internalAccount.setAccountType(3);
			break;
		case "ngo":
			internalAccount.setAccountType(4);
			break;
		case "corporate":
			internalAccount.setAccountType(5);
			break;
		}

		return internalAccount;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
