package com.templatemethod.pattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;

import com.templatemethod.beans.ApplyLoanDetails;
import com.templatemethod.beans.BankAccount;
import com.templatemethod.beans.Identity;
import com.templatemethod.beans.LoanApplication;
import com.templatemethod.beans.PersonalInfo;

public abstract class LoanManager {

	// Template method, written with common algorithm that is applicable for all the
	// sub-classes of this class
	public void processLoan(LoanApplication loanApplication) {
		boolean demographicInfoStatus = false;
		boolean identityStatus = false;
		boolean bankAccountStatus = false;
		boolean checkEligibility = false;
		double eligibilityAmount = 0;

		demographicInfoStatus = checkDemographicInformation(loanApplication.getPersonalInfo());
		if (demographicInfoStatus == false) {
			System.out.println("ERROR!: demographic verification failed");
			return;
		}

		identityStatus = verifyIdentity(loanApplication.getIdentity());
		if (identityStatus == false) {
			System.out.println("ERROR: identity mis-matched");
			return;
		}

		bankAccountStatus = verifyBankAccount(loanApplication.getBankAccount());
		if (bankAccountStatus == false) {
			System.out.println("ERROR: bank account details are not correct");
			return;
		}

		checkEligibility = checkEligibility(loanApplication.getApplyLoanDetails());
		if (checkEligibility == false) {
			System.out.println("ERROR: Does not meet loan eligibility criteria");
			return;
		}

		eligibilityAmount = getEligibleLoanAmount(loanApplication);
		issueLoanCertificate(loanApplication, eligibilityAmount);
	}

	public boolean checkDemographicInformation(PersonalInfo personalInfo) {
		if (personalInfo.getFullName() == null || personalInfo.getFullName().trim().length() == 0) {
			System.out.println("ERROR: Full Name is blank");
			return false;
		}

		LocalDate localDob = LocalDate.of(personalInfo.getDob().getYear(), personalInfo.getDob().getMonth(),
				personalInfo.getDob().getDay());

		int years = Period.between(LocalDate.now(), localDob).getYears();
		if (years > 100) {
			System.out.println("ERROR: dob entered is not valid years : " + years);
			return false;
		}

		if (personalInfo.getGender() == null || personalInfo.getGender().trim().length() == 0) {
			System.out.println("ERROR: gender is blank");
			return false;
		}

		return true;
	}

	public boolean verifyIdentity(Identity identity) {
		if (identity.getUniqueNo() == null || identity.getUniqueNo().trim().length() == 0) {
			System.out.println("ERROR: provide your unique identity no");
			return false;
		}
		if (identity.getIdentityType() == null || identity.getIdentityType().trim().length() == 0) {
			System.out.println("ERROR: provide your identity type");
			return false;
		}
		boolean flag = Arrays.asList(new String[] { "pancard", "aadhar card", "voter id" }).stream()
				.anyMatch(in -> in.equals(identity.getIdentityType()));
		if (flag == false) {
			System.out.println("ERROR: not an valid identity type, please provide aadhar card, voter id or pancard");
			return false;
		}
		return true;
	}

	public boolean verifyBankAccount(BankAccount bankAccount) {

		if (bankAccount.getAccountNo() == null || bankAccount.getAccountNo().trim().length() < 12) {
			System.out.println("ERROR: bank account no is not valid");
			return false;
		}
		if (bankAccount.getAccountType().equals("savings") == false) {
			System.out.println("ERROR: bank account is not eligible for loan disbursement");
			return false;
		}
		if (bankAccount.getIfscCode() == null || bankAccount.getIfscCode().trim().length() < 8) {
			System.out.println("ERROR: invalid ifsc code");
			return false;
		}
		return true;
	}

	abstract public boolean checkEligibility(ApplyLoanDetails applyLoanDetails);

	abstract public double getEligibleLoanAmount(LoanApplication loanApplication);

	abstract public void issueLoanCertificate(LoanApplication loanApplication, double eligibleAmount);
}
