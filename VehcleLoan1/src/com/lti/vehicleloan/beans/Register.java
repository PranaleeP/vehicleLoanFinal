package com.lti.vehicleloan.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VEHICLELOANREGISTER")
public class Register {
@Id
@Column(name="USER_NAME")
private String userName;
@Column(name="FIRST_NAME")
private String firstName;
@Column(name="LAST_NAME")
private String lastName;
@Column(name="PHONE_NO")
private long phoneNo;
@Column(name="EMAIL")
private String email;
@Column(name="PASSWORD")
private String password;
@Column(name="SECURITY_QUESTION")
private String seqQuestion;
@Column(name="SECURITY_ANSWER")
private String answer;


public Register() {
	super();
	// TODO Auto-generated constructor stub
}
public Register(String userName, String firstName, String lastName, long phoneNo, String email, String password,
		String seqQuestion, String answer) {
	super();
	this.userName = userName;
	this.firstName = firstName;
	this.lastName = lastName;
	this.phoneNo = phoneNo;
	this.email = email;
	this.password = password;
	this.seqQuestion = seqQuestion;
	this.answer = answer;
}

public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}


public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}


public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}


public long getPhoneNo() {
	return phoneNo;
}
public void setPhoneNo(long phoneNo) {
	this.phoneNo = phoneNo;
}


public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}


public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}


public String getSeqQuestion() {
	return seqQuestion;
}
public void setSeqQuestion(String seqQuestion) {
	this.seqQuestion = seqQuestion;
}


public String getAnswer() {
	return answer;
}
public void setAnswer(String answer) {
	this.answer = answer;
}


@Override
public String toString() {
	return "Register [userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNo="
			+ phoneNo + ", email=" + email + ", password=" + password + ", seqQuestion=" + seqQuestion + ", answer="
			+ answer + "]";
}


}
