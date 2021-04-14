package com.bajajpartner.service;

import com.bajajpartner.dto.InsuranceApplication;

public class PremiumManager {
	public double premiumApplicable(InsuranceApplication insuranceApplication) {
		double premiumAmount = 0;
		if (insuranceApplication.getPlanNo() == 10001) {
			if (insuranceApplication.getAge() < 55 && insuranceApplication.getGender().equals("Female")) {
				premiumAmount = 1024.50 * insuranceApplication.getTenure();
			}
			if (insuranceApplication.getAge() < 59 && insuranceApplication.getGender().equals("Male")) {
				premiumAmount = 1000.50 * insuranceApplication.getTenure();
			}
		}
		return premiumAmount;
	}
}
