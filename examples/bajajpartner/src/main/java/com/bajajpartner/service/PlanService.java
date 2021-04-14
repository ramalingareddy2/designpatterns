package com.bajajpartner.service;

import com.bajajpartner.dto.InsuranceApplication;

public class PlanService {
	public boolean checkPlanEligibility(InsuranceApplication insuranceApplication) {
		boolean eligible = true;

		if (insuranceApplication.getPlanNo() == 10001) {
			if ((insuranceApplication.getAge() > 55 && insuranceApplication.getGender().equals("Female"))
					|| (insuranceApplication.getAge() > 59 && insuranceApplication.getGender().equals("Male"))) {
				eligible = false;
			}
		}

		return eligible;
	}
}
