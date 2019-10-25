package com.lti.vehicleloan.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VLSTATUS")
public class StatusDetails {
@Column(name="USERNAME")
private String userName;
@Id
@Column(name="APPLICATIONID")
private int applicationId;
@Column(name="LOANID")
private int loanId;
@Column(name="STATUS")
private String status;
@Column(name="DESCRIPTION")
private String description;
@Column(name="APPROVALDATE")
private Date dateofApproval;
@Column(name="LOANAMOUNT")
private double loanAmount;
@Column(name="EMI")
private double emi;
public StatusDetails() {
	super();
	// TODO Auto-generated constructor stub
}
public StatusDetails(String userName, int applicationId, int loanId, String status, String description,
		Date dateofApproval, double loanAmount, double emi) {
	super();
	this.userName = userName;
	this.applicationId = applicationId;
	this.loanId = loanId;
	this.status = status;
	this.description = description;
	this.dateofApproval = dateofApproval;
	this.loanAmount = loanAmount;
	this.emi = emi;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
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
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Date getDateofApproval() {
	return dateofApproval;
}
public void setDateofApproval(Date dateofApproval) {
	this.dateofApproval = dateofApproval;
}
public double getLoanAmount() {
	return loanAmount;
}
public void setLoanAmount(double loanAmount) {
	this.loanAmount = loanAmount;
}
public double getEmi() {
	return emi;
}
public void setEmi(double emi) {
	this.emi = emi;
}
@Override
public String toString() {
	return "StatusDetails [userName=" + userName + ", applicationId=" + applicationId + ", loanId=" + loanId
			+ ", status=" + status + ", description=" + description + ", dateofApproval=" + dateofApproval
			+ ", loanAmount=" + loanAmount + ", emi=" + emi + "]";
}

}
