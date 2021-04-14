package com.afp.jio.service;

import java.util.Arrays;
import java.util.List;

import com.afp.service.MobileRechargeService;

public class JioPrepaidMobileRechargeService implements MobileRechargeService {

	@Override
	public List<String> getDataPlans() {
		return Arrays.asList(new String[] { "JIO-199", "JIO-129", "JIO-399-UNLIMITED" });
	}

}
