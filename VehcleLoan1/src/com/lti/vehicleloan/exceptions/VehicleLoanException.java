package com.lti.vehicleloan.exceptions;

public class VehicleLoanException extends Exception
{

	public VehicleLoanException(String message, Throwable cause) {
		super(message, cause);
	}

	public VehicleLoanException(String message) {
		super(message);
	}
}
