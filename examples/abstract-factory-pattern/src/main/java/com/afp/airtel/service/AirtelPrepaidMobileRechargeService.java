package com.afp.airtel.service;

import java.util.Arrays;
import java.util.List;

import com.afp.service.MobileRechargeService;

public class AirtelPrepaidMobileRechargeService implements MobileRechargeService {

	@Override
	public List<String> getDataPlans() {
		return Arrays.asList(new String[] { "AIRTEL-199", "AIRTEL-129", "AIRTEL-399-UNLIMITED" });
	}

}
