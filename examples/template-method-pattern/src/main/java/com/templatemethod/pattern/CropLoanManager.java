package com.templatemethod.pattern;

import java.util.Arrays;
import java.util.stream.Collectors;

import com.templatemethod.beans.ApplyLoanDetails;
import com.templatemethod.beans.LoanApplication;

public class CropLoanManager extends LoanManager {

	@Override
	public boolean checkEligibility(ApplyLoanDetails applyLoanDetails) {
		return Arrays.asList(new String[] { "rice", "dal", "wheat", "pulses", "cotton" }).stream().anyMatch(crop -> {
			return crop.equals(applyLoanDetails.getCrop());
		});
	}

	@Override
	public double getEligibleLoanAmount(LoanApplication loanApplication) {
		return Arrays.asList(new String[] { "rice", "dal", "wheat", "pulses", "cotton" }).stream().filter(crop -> {
			return crop.equals(loanApplication.getApplyLoanDetails().getCrop());
		}).map(crop -> {
			if (crop.equals("rice")) {
				return 300000;
			} else if (crop.equals("dal")) {
				return 250000;
			} else if (crop.equals("wheat")) {
				return 200000;
			} else if (crop.equals("pulses")) {
				return 120000;
			} else if (crop.equals("cotton")) {
				return 220000;
			}
			return 0;
		}).collect(Collectors.toList()).get(0);
	}

	@Override
	public void issueLoanCertificate(LoanApplication loanApplication, double eligibleAmount) {
		System.out.println("To Sbi bank, Issue the loan to : " + loanApplication.getPersonalInfo().getFullName()
				+ " For the crop : " + loanApplication.getApplyLoanDetails().getCrop() + " of an amount : "
				+ eligibleAmount);
	}

}
