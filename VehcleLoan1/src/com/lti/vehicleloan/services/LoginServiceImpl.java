package com.lti.vehicleloan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.vehicleloan.beans.LoanDetails;
import com.lti.vehicleloan.beans.PersonalDetails;
import com.lti.vehicleloan.beans.Register;
import com.lti.vehicleloan.beans.StatusDetails;
import com.lti.vehicleloan.daos.ApplicationDao;
import com.lti.vehicleloan.daos.LoginDao;
import com.lti.vehicleloan.exceptions.VehicleLoanException;

@Service("loginService")
@ Transactional(propagation=Propagation.REQUIRES_NEW)
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginDao dao;

	@Override
	public List<Register> getAppList() throws VehicleLoanException {
		return dao.getAppList();
	}

	@Override
	public List<LoanDetails> getAllDetails() throws VehicleLoanException {
		return dao.getAllList();
	}

	@Override
	public Register getUser(String uName) throws VehicleLoanException {
		return dao.getUser(uName);
	}

	@Override
	public PersonalDetails getApplicantDetails(int applicationId) throws VehicleLoanException {
		return dao.getApplicantDetails(applicationId);
	}

	@Override
	public LoanDetails getLoanDetails(int applicationId) throws VehicleLoanException {
		return dao.getLoanDetails(applicationId);
	}

	@Override
	public List<PersonalDetails> getApplicationList() throws VehicleLoanException {
		return dao.getApplicationList();
	}

	@Override
	public StatusDetails addStatusDetails(StatusDetails sd) throws VehicleLoanException {
		return dao.addStatusDetails(sd);
	}

	@Override
	public List<StatusDetails> getMyApplications(String userName) throws VehicleLoanException {
		return dao.getMyApplications(userName);
	}

	@Override
	public List<StatusDetails> getApprovedApplication()throws VehicleLoanException{
	return dao.getApprovedApplication();
	}

	@Override
	public List<StatusDetails> getRejectedApplication() throws VehicleLoanException {

		return dao.getRejectedApplication();
	}

	@Override
	public StatusDetails getStatus(int appId) throws VehicleLoanException {
	
		return dao.getStatus(appId);
	}
}
