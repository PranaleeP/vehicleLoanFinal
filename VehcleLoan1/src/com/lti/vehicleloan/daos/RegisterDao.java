package com.lti.vehicleloan.daos;

import com.lti.vehicleloan.beans.Register;
import com.lti.vehicleloan.exceptions.VehicleLoanException;

public interface RegisterDao {
public Register registerUser(Register reg) throws VehicleLoanException;
public boolean verifyUser(String name,String pass)throws VehicleLoanException;
}
