package com.amexinsurance.service;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.amexinsurance.locator.BajajInsuranceServiceLocator;
import com.bajajpartner.dto.InsuranceApplication;
import com.bajajpartner.dto.Policy;
import com.bajajpartner.remote.BajajAlianzPartnerInsuranceService;

public class AmericanExpressInsuranceService {

	public Policy enroll(InsuranceApplication insuranceApplication)
			throws MalformedURLException, RemoteException, NotBoundException {
		BajajAlianzPartnerInsuranceService remote = null;
		Policy policy = null;

		remote = BajajInsuranceServiceLocator.locateInsuranceService();
		policy = remote.enroll(insuranceApplication);

		// business logic
		policy.setPolicyNo(policy.getPolicyNo() + "AM");
		policy.setPremiumAmount(policy.getPremiumAmount() + 1000);

		return policy;
	}
}
