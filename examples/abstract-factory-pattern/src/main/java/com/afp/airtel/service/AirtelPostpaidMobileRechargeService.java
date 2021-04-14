package com.afp.airtel.service;

import java.util.Arrays;
import java.util.List;

import com.afp.service.MobileRechargeService;

public class AirtelPostpaidMobileRechargeService implements MobileRechargeService {

	@Override
	public List<String> getDataPlans() {
		return Arrays.asList(new String[] { "AIRTEL-POSTPAID-299", "AIRTEL-POSTPAID-349" });
	}
}
