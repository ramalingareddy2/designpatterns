package com.afp.jio.service;

import java.util.Arrays;
import java.util.List;

import com.afp.service.MobileRechargeService;

public class JioPostpaidMobileRechargeService implements MobileRechargeService {

	@Override
	public List<String> getDataPlans() {
		return Arrays.asList(new String[] { "JIO-POSTPAID-299", "JIO-POSTPAID-349" });
	}

}
