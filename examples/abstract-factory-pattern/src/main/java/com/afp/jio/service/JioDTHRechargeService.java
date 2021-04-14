package com.afp.jio.service;

import java.util.Arrays;
import java.util.List;

import com.afp.service.DTHRechargeService;

public class JioDTHRechargeService implements DTHRechargeService {

	@Override
	public List<String> getDTHPackages() {
		return Arrays.asList(new String[] { "JIO-SOUTH-FAMILY-400", "JIO-SPORTS-349" });
	}

}
