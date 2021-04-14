package com.templatemethod.pattern;

import java.util.Arrays;
import java.util.stream.Collectors;

import com.templatemethod.beans.ApplyLoanDetails;
import com.templatemethod.beans.LoanApplication;

public class FisheriesLoanManager extends LoanManager {

	@Override
	public boolean checkEligibility(ApplyLoanDetails applyLoanDetails) {
		return Arrays.asList(new String[] { "prawn", "fish" }).stream().anyMatch(crop -> {
			return crop.equals(applyLoanDetails.getCrop());
		});
	}

	@Override
	public double getEligibleLoanAmount(LoanApplication loanApplication) {
		return Arrays.asList(new String[] { "prawn", "fish" }).stream().filter(crop -> {
			return crop.equals(loanApplication.getApplyLoanDetails().getCrop());
		}).map(crop -> {
			if (crop.equals("prawn")) {
				return 500000;
			} else if (crop.equals("fish")) {
				return 350000;
			}
			return 0;
		}).collect(Collectors.toList()).get(0);
	}

	@Override
	public void issueLoanCertificate(LoanApplication loanApplication, double eligibleAmount) {
		System.out.println("To Idbi bank, Issue the loan to : " + loanApplication.getPersonalInfo().getFullName()
				+ " For the crop : " + loanApplication.getApplyLoanDetails().getCrop() + " of an amount : "
				+ eligibleAmount);
	}

}
