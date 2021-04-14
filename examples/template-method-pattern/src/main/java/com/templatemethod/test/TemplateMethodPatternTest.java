package com.templatemethod.test;

import java.util.Date;

import com.templatemethod.beans.ApplyLoanDetails;
import com.templatemethod.beans.BankAccount;
import com.templatemethod.beans.Identity;
import com.templatemethod.beans.LoanApplication;
import com.templatemethod.beans.PersonalInfo;
import com.templatemethod.pattern.CropLoanManager;
import com.templatemethod.pattern.LoanManager;

public class TemplateMethodPatternTest {
	public static void main(String[] args) {
		PersonalInfo personalInfo = new PersonalInfo("Samuel J", new Date(), "Male", "92938993", "samuel@gmail.com");
		Identity identity = new Identity("83303283df", "aadhar card", "Govt India");
		BankAccount bankAccount = new BankAccount("ac9393903231", "savings", "icici bank", "icici0002");
		ApplyLoanDetails applyLoanDetails = new ApplyLoanDetails("Agriculture", "rice", "rice crop", 50000.0);
		LoanApplication loanApplication = new LoanApplication(personalInfo, identity, bankAccount, applyLoanDetails);

		LoanManager loanManager = new CropLoanManager();
		loanManager.processLoan(loanApplication);
	}
}
