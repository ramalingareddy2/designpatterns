package com.bajajpartner.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.bajajpartner.dto.InsuranceApplication;
import com.bajajpartner.dto.Policy;

public interface BajajAlianzPartnerInsuranceService extends Remote {
	Policy enroll(InsuranceApplication insuranceApplication) throws RemoteException;
}
