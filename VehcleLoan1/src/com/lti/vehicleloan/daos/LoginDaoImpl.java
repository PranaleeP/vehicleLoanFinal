package com.lti.vehicleloan.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.vehicleloan.beans.LoanDetails;
import com.lti.vehicleloan.beans.PersonalDetails;
import com.lti.vehicleloan.beans.Register;
import com.lti.vehicleloan.beans.StatusDetails;
import com.lti.vehicleloan.exceptions.VehicleLoanException;

@Repository
@Transactional(propagation=Propagation.REQUIRED)
public class LoginDaoImpl implements LoginDao {

	@PersistenceContext	
	private EntityManager manager;
	
	@Override
	public List<Register> getAppList() throws VehicleLoanException {
		Query qry=manager.createQuery("from Register")	;
		return qry.getResultList();
	}

	/*@Override
	public List<PersonalDetails> getAppDetails(String uName) throws VehicleLoanException {
		Query qry = manager.createQuery("select p from PersonalDetails p where p.userName =:uName").setParameter("uName", uName);
		return qry.getResultList();
	}*/

	@Override
	public List<LoanDetails> getAllList() throws VehicleLoanException {
		Query qry=manager.createQuery("from LoanDetails")	;
			return qry.getResultList();
	}

	@Override
	public Register getUser(String uName) throws VehicleLoanException {
		Query qry = manager.createQuery("select r from Register r where r.userName =:uName").setParameter("uName", uName);
		return (Register) qry.getSingleResult();
		
	}

	@Override
	public PersonalDetails getApplicantDetails(int applicationId) throws VehicleLoanException {
		Query qry = manager.createQuery("select p from PersonalDetails p where  p.applicationId =:applicationId").setParameter("applicationId", applicationId);
		return (PersonalDetails) qry.getSingleResult();
	}

	@Override
	public LoanDetails getLoanDetails(int applicationId) throws VehicleLoanException {
		Query qry = manager.createQuery("select l from LoanDetails l where  l.applicationId =:applicationId").setParameter("applicationId", applicationId);
		return (LoanDetails) qry.getSingleResult();
	}

	@Override
	public List<PersonalDetails> getApplicationList() throws VehicleLoanException {
		Query qry=manager.createQuery("from PersonalDetails")	;
		return  qry.getResultList();
	}

	@Override
	public StatusDetails addStatusDetails(StatusDetails sd) throws VehicleLoanException {
		try{
			manager.persist(sd);
		}catch(Exception e) {
			
			throw new VehicleLoanException("This application is already Processed",e);
		}
		return sd;
		}
		
	@Override
	public List<StatusDetails> getMyApplications(String userName) throws VehicleLoanException {
		Query qry = manager.createQuery("select s from StatusDetails s where s.userName =:userName").setParameter("userName", userName);
		return  qry.getResultList();
	}

	@Override
	public List<StatusDetails> getApprovedApplication() throws VehicleLoanException {
		Query qry = manager.createQuery("select s from StatusDetails s where s.status ='Approve'");
		System.out.println(qry.getResultList());
		return qry.getResultList();
	}

	@Override
	public List<StatusDetails> getRejectedApplication() throws VehicleLoanException {
		Query qry = manager.createQuery("select s from StatusDetails s where s.status ='Reject'");
		System.out.println(qry.getResultList());
		return qry.getResultList();
	}

	@Override
	public StatusDetails getStatus(int appId) throws VehicleLoanException {
		Query qry = manager.createQuery("select s from StatusDetails s where s.applicationId =:applicationId").setParameter("applicationId", appId); 
		return (StatusDetails) qry.getSingleResult();
	}
	
}
