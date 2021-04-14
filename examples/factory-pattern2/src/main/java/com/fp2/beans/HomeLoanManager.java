package com.fp2.beans;

public class HomeLoanManager implements LoanManager {
	private String propertyType;
	private String city;

	public HomeLoanManager(String propertyType, String city) {
		this.propertyType = propertyType;
		this.city = city;
	}

	@Override
	public double applicableInterestRate(double principle, long tenure) {
		if (propertyType.equals("independent house")) {
			return 7.75;
		}
		return 8.75;
	}

}
