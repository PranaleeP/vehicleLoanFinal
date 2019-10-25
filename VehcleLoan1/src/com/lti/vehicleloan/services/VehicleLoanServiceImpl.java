package com.lti.vehicleloan.services;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.vehicleloan.beans.DocumentsUpload;
import com.lti.vehicleloan.beans.Register;
import com.lti.vehicleloan.daos.RegisterDao;
import com.lti.vehicleloan.exceptions.VehicleLoanException;

@Service("vehicleLoanService")
@ Transactional(propagation=Propagation.REQUIRES_NEW)
public class VehicleLoanServiceImpl implements VehicleLoanService{
	
	//VehicleLoanServiceImpl impl = new VehicleLoanService();
	@Autowired
	private RegisterDao dao;

	@Override
	public boolean getEligibility(HttpServletRequest request) throws VehicleLoanException {
		double totalEmi = 0;
		double price=Double.parseDouble(request.getParameter("showroomPrice"));
		double annualIncome=Double.parseDouble(request.getParameter("annualSalary"));
		double existingEmi=Double.parseDouble(request.getParameter("existingEmi"));
		int age=Integer.parseInt(request.getParameter("age"));
		if(age >= 21 && age <= 65)
		{	
			annualIncome = annualIncome - (existingEmi*12); //Annual Salary after deduction of existing EMI
			totalEmi = annualIncome * 0.43 * 7; //Maximum EMI to be allowed is 43% of the salary
			if(price < totalEmi)
			{
				System.out.println("Print Eligible");
				return true;
			}
		}
		return false;
	}

	/*@Override
	public Register registerUser(Register reg) throws VehicleLoanException {
		return dao.registerUser(reg);

	}*/

	@Override
	public Register addUser(HttpServletRequest request,Register rd) throws VehicleLoanException {
		String securityQ=request.getParameter("sq");
	    rd.setSeqQuestion(securityQ);
	    
		//return registerUser(reg);
		return dao.registerUser(rd);
	}

	@Override
	public boolean loginuser(HttpServletRequest request) throws VehicleLoanException {
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		
		boolean  status =dao.verifyUser(userName, password);
		if(status) {
			
		return true;
		}else {
		return false;
	}
	}

@Override
	public boolean calculateEMI(HttpServletRequest request) throws VehicleLoanException {

		Double LoanAmount=(Double.parseDouble(request.getParameter("loanAmount")));
		Double LoanTenure=(Double.parseDouble(request.getParameter("loanTenure")));
		Double RateOfInterest=(Double.parseDouble(request.getParameter("rateOfInterest")));
		
		RateOfInterest=RateOfInterest/(12*100);
		
        //Double emi= (LoanAmount*RateOfInterest*Math.pow(1+RateOfInterest,LoanTenure))/ (Math.pow(1+RateOfInterest,LoanTenure)-1);

        Double emi= (LoanAmount*RateOfInterest*( (Math.pow(1+RateOfInterest,LoanTenure))/ ((Math.pow(1+RateOfInterest,LoanTenure)-1))));
		System.out.println(emi);
        request.setAttribute("emi", emi);
		
		return true;
	}
	
	}


