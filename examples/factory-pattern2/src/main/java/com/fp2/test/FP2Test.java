package com.fp2.test;

import com.fp2.beans.LoanEstimator;

public class FP2Test {
	public static void main(String[] args) {
		LoanEstimator loanEstimator = new LoanEstimator();
		loanEstimator.estimateInterestAmountForPersonalLoan("salaried", 1000001, 500000, 24, "google");

	}
}
