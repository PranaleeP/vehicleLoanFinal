package com.lti.vehicleloan.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VLLOANDETAILS")
public class LoanDetails {

	@Column(name="APPLICATIONID")
	private int applicationId;
	
	@Id
	@Column(name="LOANID")
	private int loanId;
	
	@Column(name="VEHICLEMAKE")
	private String vehicleMake;
	
	@Column(name="VEHICLEMODEL")
	private String vehicleModel;
	
	@Column(name="EXSHOWROOMPRICE")
	private double exShowroomPrice;
	
	@Column(name="LOANAMOUNT")
	private double loanAmount;
	
	@Column(name="LOANTENURE")
	private int loanTenure;
	
	@Column(name="RATEOFINTEREST")
	private float ROI;
	
	
	
	public LoanDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public LoanDetails(int applicationId, int loanId, String vehicleMake, String vehicleModel, double exShowroomPrice,
			double loanAmount, int loanTenure, float rOI) {
		super();
		this.applicationId = applicationId;
		this.loanId = loanId;
		this.vehicleMake = vehicleMake;
		this.vehicleModel = vehicleModel;
		this.exShowroomPrice = exShowroomPrice;
		this.loanAmount = loanAmount;
		this.loanTenure = loanTenure;
		ROI = rOI;
	}


	public int getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	public int getLoanId() {
		return loanId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	public String getVehicleMake() {
		return vehicleMake;
	}
	public void setVehicleMake(String vehicleMake) {
		this.vehicleMake = vehicleMake;
	}
	public String getVehicleModel() {
		return vehicleModel;
	}
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
	public double getExShowroomPrice() {
		return exShowroomPrice;
	}
	public void setExShowroomPrice(double exShowroomPrice) {
		this.exShowroomPrice = exShowroomPrice;
	}
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public int getLoanTenure() {
		return loanTenure;
	}
	public void setLoanTenure(int loanTenure) {
		this.loanTenure = loanTenure;
	}

	public float getROI() {
		return ROI;
	}

	public void setROI(float rOI) {
		ROI = rOI;
	}

	@Override
	public String toString() {
		return "LoanDetails [applicationId=" + applicationId + ", loanId=" + loanId + ", vehicleMake=" + vehicleMake
				+ ", vehicleModel=" + vehicleModel + ", exShowroomPrice=" + exShowroomPrice + ", loanAmount="
				+ loanAmount + ", loanTenure=" + loanTenure + ", ROI=" + ROI + "]";
	}
	
	
}
