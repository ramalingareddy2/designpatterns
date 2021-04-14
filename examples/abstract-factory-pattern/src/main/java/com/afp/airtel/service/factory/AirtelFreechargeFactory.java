package com.afp.airtel.service.factory;

import com.afp.airtel.service.AirtelDTHRechargeService;
import com.afp.airtel.service.AirtelPostpaidMobileRechargeService;
import com.afp.airtel.service.AirtelPrepaidMobileRechargeService;
import com.afp.service.DTHRechargeService;
import com.afp.service.MobileRechargeService;
import com.afp.service.factory.FreechargeFactory;

public class AirtelFreechargeFactory extends FreechargeFactory {

	@Override
	public MobileRechargeService newMobileRechargeService(String rechargeType) {
		MobileRechargeService mobileRechargeService = null;

		if (rechargeType.equals("prepaid")) {
			mobileRechargeService = new AirtelPrepaidMobileRechargeService();
		} else if (rechargeType.equals("postpaid")) {
			mobileRechargeService = new AirtelPostpaidMobileRechargeService();
		}

		return mobileRechargeService;
	}

	@Override
	public DTHRechargeService newDTHRechargeService() {
		return new AirtelDTHRechargeService();
	}

}
