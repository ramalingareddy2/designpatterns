package com.afp.jio.service.factory;

import com.afp.jio.service.JioDTHRechargeService;
import com.afp.jio.service.JioPostpaidMobileRechargeService;
import com.afp.jio.service.JioPrepaidMobileRechargeService;
import com.afp.service.DTHRechargeService;
import com.afp.service.MobileRechargeService;
import com.afp.service.factory.FreechargeFactory;

public class JioFreechargeFactory extends FreechargeFactory {

	@Override
	public MobileRechargeService newMobileRechargeService(String rechargeType) {
		MobileRechargeService mobileRechargeService = null;

		if (rechargeType.equals("prepaid")) {
			mobileRechargeService = new JioPrepaidMobileRechargeService();
		} else if (rechargeType.equals("postpaid")) {
			mobileRechargeService = new JioPostpaidMobileRechargeService();
		}

		return mobileRechargeService;
	}

	@Override
	public DTHRechargeService newDTHRechargeService() {
		return new JioDTHRechargeService();
	}

}
