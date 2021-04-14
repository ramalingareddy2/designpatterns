package com.bajajpartner.service;

import java.util.Date;
import java.util.UUID;

import com.bajajpartner.dto.InsuranceApplication;
import com.bajajpartner.dto.Policy;

public class EnrollmentService {
	public Policy enroll(InsuranceApplication application, double applicablePremiumAmount) {
		Policy policy = null;

		policy = new Policy(UUID.randomUUID().toString(), application.getMemberName(), application.getPlanNo(),
				new Date(), new Date(), application.getInsurredAmount(), applicablePremiumAmount);

		return policy;
	}
}
