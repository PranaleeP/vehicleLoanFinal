package com.lti.vehicleloan.daos;

import com.lti.vehicleloan.beans.LoanDetails;
import com.lti.vehicleloan.beans.PersonalDetails;
import com.lti.vehicleloan.exceptions.VehicleLoanException;

public interface ApplicationDao {

	public PersonalDetails addPDetails(PersonalDetails pd) throws VehicleLoanException;
	public int createAppId()throws VehicleLoanException;
	public int createLoanId()throws VehicleLoanException;
	public LoanDetails addLDetails(LoanDetails ld) throws VehicleLoanException;
}
