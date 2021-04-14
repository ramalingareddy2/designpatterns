package com.amexinsurance.agent;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.amexinsurance.service.AmericanExpressInsuranceService;
import com.bajajpartner.dto.InsuranceApplication;
import com.bajajpartner.dto.Policy;

public class InsuranceAgent {
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		AmericanExpressInsuranceService americanExpressInsuranceService = null;
		InsuranceApplication insuranceApplication = null;
		Policy policy = null;

		insuranceApplication = new InsuranceApplication();
		insuranceApplication.setMemberName("Martin J");
		insuranceApplication.setAge(45);
		insuranceApplication.setGender("Male");
		insuranceApplication.setPlanNo(10001);
		insuranceApplication.setTenure(24);
		insuranceApplication.setInsurredAmount(600000);

		americanExpressInsuranceService = new AmericanExpressInsuranceService();
		policy = americanExpressInsuranceService.enroll(insuranceApplication);
		System.out.println("policyNo : " + policy.getPolicyNo() + " premium : " + policy.getPremiumAmount());
	}
}
