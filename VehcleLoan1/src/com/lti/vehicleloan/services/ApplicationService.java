package com.lti.vehicleloan.services;

import javax.servlet.http.HttpServletRequest;

import com.lti.vehicleloan.beans.LoanDetails;
import com.lti.vehicleloan.beans.PersonalDetails;
import com.lti.vehicleloan.exceptions.VehicleLoanException;

public interface ApplicationService {
	
	//public PersonalDetails addPDetails(HttpServletRequest request) throws VehicleLoanException;
	public PersonalDetails addPDetails(PersonalDetails pd) throws VehicleLoanException;
	//public LoanDetails addLDetails(HttpServletRequest request) throws VehicleLoanException;
	public LoanDetails addLDetails(LoanDetails Ld) throws VehicleLoanException;
	
}
