package com.bajajpartner.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.bajajpartner.dto.InsuranceApplication;
import com.bajajpartner.dto.Policy;
import com.bajajpartner.service.EnrollmentService;
import com.bajajpartner.service.PlanService;
import com.bajajpartner.service.PremiumManager;

public class BajajAlianzPartnerInsuranceServiceImpl extends UnicastRemoteObject
		implements BajajAlianzPartnerInsuranceService {

	public BajajAlianzPartnerInsuranceServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public Policy enroll(InsuranceApplication insuranceApplication) throws RemoteException {
		Policy policy = null;
		double premiumAmount = 0;
		PlanService planService = null;
		PremiumManager premiumManager = null;
		EnrollmentService enrollmentService = null;

		planService = new PlanService();
		if (planService.checkPlanEligibility(insuranceApplication) == false) {
			throw new RemoteException("You are not eligible for enrolling into this plan");
		}
		premiumManager = new PremiumManager();
		premiumAmount = premiumManager.premiumApplicable(insuranceApplication);

		enrollmentService = new EnrollmentService();
		policy = enrollmentService.enroll(insuranceApplication, premiumAmount);

		return policy;
	}

}
