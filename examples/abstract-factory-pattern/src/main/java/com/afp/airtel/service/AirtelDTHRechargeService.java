package com.afp.airtel.service;

import java.util.Arrays;
import java.util.List;

import com.afp.service.DTHRechargeService;

public class AirtelDTHRechargeService implements DTHRechargeService {

	@Override
	public List<String> getDTHPackages() {
		return Arrays.asList(new String[] { "AIRTEL-SOUTH-FAMILY-400", "AIRTEL-SPORTS-349" });
	}

}
