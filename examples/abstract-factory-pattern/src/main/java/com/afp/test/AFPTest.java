package com.afp.test;

import java.io.IOException;
import java.util.List;

import com.afp.service.MobileRechargeService;
import com.afp.service.factory.FreechargeFactory;

public class AFPTest {
	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		FreechargeFactory freechargeFactory = FreechargeFactory.newInstance();
		MobileRechargeService mobileRechargeService = freechargeFactory.newMobileRechargeService("prepaid");

		List<String> dataPlans = mobileRechargeService.getDataPlans();

		dataPlans.stream().forEach(System.out::println);

	}
}
