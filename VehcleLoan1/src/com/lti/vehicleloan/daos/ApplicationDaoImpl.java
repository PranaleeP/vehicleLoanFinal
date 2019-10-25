package com.lti.vehicleloan.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.vehicleloan.beans.LoanDetails;
import com.lti.vehicleloan.beans.PersonalDetails;
import com.lti.vehicleloan.exceptions.VehicleLoanException;
import com.lti.vehicleloan.services.VehicleLoanService;

@Repository
@Transactional(propagation=Propagation.REQUIRED)
public class ApplicationDaoImpl implements ApplicationDao{

	@PersistenceContext	
	private EntityManager manager;

	int appId =0;
	PersonalDetails perDet =new PersonalDetails();
	
	@Override
	public PersonalDetails addPDetails(PersonalDetails pd) throws VehicleLoanException {
		 appId=createAppId();
		 perDet=pd;
		 perDet.setApplicationId(appId);
		//manager.persist(pd);
		return perDet;
	}

	@Override
	public int createAppId() throws VehicleLoanException {
		Query qry= manager.createQuery("select max(applicationId) from PersonalDetails");
		int id=(int)qry.getSingleResult();
		return id+1;
	}
	
	@Override
	public int createLoanId() throws VehicleLoanException {
		Query qry= manager.createQuery("select max(loanId) from LoanDetails");
		int id=(int)qry.getSingleResult();
		System.out.println(id);
		return id+1;
	}

	@Override
	public LoanDetails addLDetails(LoanDetails loand) throws VehicleLoanException {
		int loanId=createLoanId();
		loand.setLoanId(loanId);
		loand.setApplicationId(appId);
		System.out.println(loand);
		System.out.println(perDet);
			
		manager.persist(perDet);
		manager.persist(loand);
		return  loand;
	}
	
}
