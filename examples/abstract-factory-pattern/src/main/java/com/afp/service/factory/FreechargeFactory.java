package com.afp.service.factory;

import java.io.IOException;
import java.util.Properties;

import com.afp.service.DTHRechargeService;
import com.afp.service.MobileRechargeService;

public abstract class FreechargeFactory {
	public static FreechargeFactory newInstance()
			throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		FreechargeFactory freechargeFactory = null;
		Properties props = null;
		String factoryClass = null;

		props = new Properties();
		props.load(FreechargeFactory.class.getClassLoader().getResourceAsStream("freecharge.properties"));
		factoryClass = props.getProperty("com.afp.service.FreeChargeFactory");

		freechargeFactory = (FreechargeFactory) Class.forName(factoryClass).newInstance();

		return freechargeFactory;
	}

	public abstract MobileRechargeService newMobileRechargeService(String rechargeType);

	public abstract DTHRechargeService newDTHRechargeService();
}
