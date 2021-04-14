package com.bajajpartner.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import com.bajajpartner.remote.BajajAlianzPartnerInsuranceService;
import com.bajajpartner.remote.BajajAlianzPartnerInsuranceServiceImpl;

public class BajajServer {
	public static void main(String[] args) throws RemoteException, MalformedURLException {
		// rmi server
		LocateRegistry.createRegistry(9009);
		BajajAlianzPartnerInsuranceService remote = new BajajAlianzPartnerInsuranceServiceImpl();

		Naming.rebind("rmi://localhost:9009/bajajInsuranceService", remote);
		System.out.println("rmi server started...");
	}
}
