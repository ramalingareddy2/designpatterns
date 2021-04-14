package com.amexinsurance.locator;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.bajajpartner.remote.BajajAlianzPartnerInsuranceService;

public class BajajInsuranceServiceLocator {
	public static BajajAlianzPartnerInsuranceService locateInsuranceService()
			throws MalformedURLException, RemoteException, NotBoundException {
		BajajAlianzPartnerInsuranceService remote = null;

		// this creates a runtime stub and returns the object
		remote = (BajajAlianzPartnerInsuranceService) Naming.lookup("rmi://localhost:9009/bajajInsuranceService");

		return remote;
	}
}
