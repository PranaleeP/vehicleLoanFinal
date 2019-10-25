package com.lti.vehicleloan.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.vehicleloan.beans.LoanDetails;
import com.lti.vehicleloan.beans.PersonalDetails;
import com.lti.vehicleloan.daos.ApplicationDao;
import com.lti.vehicleloan.exceptions.VehicleLoanException;

@Service
@ Transactional(propagation=Propagation.REQUIRES_NEW)
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	private ApplicationDao adao;
	
	@Override
	public PersonalDetails addPDetails(PersonalDetails pd) throws VehicleLoanException {

		return adao.addPDetails(pd);
	}

	@Override
	public LoanDetails addLDetails(LoanDetails Ld) throws VehicleLoanException {
		
		return adao.addLDetails(Ld);
	}

}
