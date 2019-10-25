package com.lti.vehicleloan.services;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.lti.vehicleloan.beans.DocumentsUpload;
import com.lti.vehicleloan.beans.Register;
import com.lti.vehicleloan.exceptions.VehicleLoanException;


public interface VehicleLoanService {
	public boolean getEligibility(HttpServletRequest request)throws VehicleLoanException;
	//public Register registerUser(Register reg) throws VehicleLoanException;
	public Register addUser(HttpServletRequest request,Register rd) throws VehicleLoanException;
	public boolean loginuser(HttpServletRequest request) throws VehicleLoanException;
	public boolean calculateEMI(HttpServletRequest request)throws VehicleLoanException;
	
}
