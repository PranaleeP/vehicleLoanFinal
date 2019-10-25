package com.lti.vehicleloan.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="VLCUSTOMERPERSONALDETAILS")
public class PersonalDetails {
	@Column(name="USERNAME")
	private String userName;
	@Id
	@Column(name="APPLICATIONID")
	private int applicationId;
	@Column(name="AGE")
	private int age;
	@Column(name="GENDER")
	private String gender;
	@Column(name="ADDRESS")
	private String address;
	@Column(name="STATE")
	private String state;
	@Column(name="CITY")
	private String city;
	@Column(name="PINCODE")
	private long pincode;
	@Column(name="EMPLOYMENTTYPE")
	private String employment;
	@Column(name="ANNUALSALARY")
	private float annualSalary;
	@Column(name="EXISTINGEMI")
	private float existingEmi;
	
	
	public PersonalDetails() {
		super();
	}

	public PersonalDetails(String userName,int applicationId, int age, String gender, String address, String state,
			String city, long pincode, String employment, float annualSalary, float existingEmi) {
		super();
		this.userName = userName;
		this.applicationId = applicationId;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
		this.employment = employment;
		this.annualSalary = annualSalary;
		this.existingEmi = existingEmi;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public int  getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	
	public String getEmployment() {
		return employment;
	}

	public void setEmployment(String employment) {
		this.employment = employment;
	}

	public float getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(float annualSalary) {
		this.annualSalary = annualSalary;
	}

	public float getExistingEmi() {
		return existingEmi;
	}

	public void setExistingEmi(float existingEmi) {
		this.existingEmi = existingEmi;
	}

	@Override
	public String toString() {
		return "PersonalDetails [userName=" + userName + ", applicationId=" + applicationId + ", age=" + age
				+ ", gender=" + gender + ", address=" + address + ", state=" + state + ", city=" + city + ", pincode="
				+ pincode + ", employment=" + employment + ", annualSalary=" + annualSalary + ", existingEmi="
				+ existingEmi + "]";
	}	
}
