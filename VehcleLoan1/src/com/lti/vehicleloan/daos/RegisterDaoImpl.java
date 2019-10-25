package com.lti.vehicleloan.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.lti.vehicleloan.beans.Register;
import com.lti.vehicleloan.exceptions.VehicleLoanException;

@Repository
@Transactional(propagation=Propagation.REQUIRED)
public class RegisterDaoImpl implements RegisterDao{

	@PersistenceContext	
	private EntityManager manager;
	
	@Override
	public Register registerUser(Register rd) throws VehicleLoanException {
		System.out.println(rd);
		boolean check =checkUser(rd);
		if(check) {
			manager.persist(rd);
			return rd;
		}
		return null;
	}
	
	 public boolean checkUser(Register rd) {
		 Register rd1 =manager.find(Register.class, rd.getUserName());
		 Register rd2= manager.find(Register.class, rd.getEmail());
		 if(rd1==null && rd2==null)
		 {
			 return true;
		 }
		 return false;
	 }

	@Override
	public boolean verifyUser(String name, String pass) throws VehicleLoanException {
		Register reg =manager.find(Register.class, name);
		System.out.println(reg);
		if(reg==null) {
			return false;
		}
		String password =reg.getPassword();
		System.out.println(password);
		if(pass.equals(password)) {
			return true;
		}
		else {
			return false;
		}
	}

}
