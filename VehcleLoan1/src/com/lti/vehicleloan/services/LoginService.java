package com.lti.vehicleloan.services;

import com.lti.vehicleloan.exceptions.VehicleLoanException;
import java.util.List;
import com.lti.vehicleloan.beans.*;

public interface LoginService {
	public List<Register> getAppList() throws VehicleLoanException;
	//public  List<PersonalDetails> getAppDetails(String uName) throws VehicleLoanException;
	public  List<LoanDetails> getAllDetails() throws VehicleLoanException;
	public List<PersonalDetails> getApplicationList() throws VehicleLoanException;
	public Register getUser(String uName)throws VehicleLoanException;
	public PersonalDetails getApplicantDetails(int applicationId)throws VehicleLoanException;
	public LoanDetails getLoanDetails(int applicationId)throws VehicleLoanException;
	public StatusDetails addStatusDetails(StatusDetails sd) throws VehicleLoanException;
	public List<StatusDetails> getMyApplications(String userName) throws VehicleLoanException;
	public List<StatusDetails> getApprovedApplication()throws VehicleLoanException;
	public List<StatusDetails> getRejectedApplication()throws VehicleLoanException;
	public StatusDetails getStatus(int appId)throws VehicleLoanException;
}
