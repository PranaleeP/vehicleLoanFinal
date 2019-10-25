package com.lti.vehicleloan.controllers;

import java.util.Calendar;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.lti.vehicleloan.beans.LoanDetails;
import com.lti.vehicleloan.beans.PersonalDetails;
import com.lti.vehicleloan.beans.Register;
import com.lti.vehicleloan.exceptions.VehicleLoanException;
import com.lti.vehicleloan.services.ApplicationService;
import com.lti.vehicleloan.services.ApplicationServiceImpl;
import com.lti.vehicleloan.services.LoginService;
import com.lti.vehicleloan.services.LoginServiceImpl;
import com.lti.vehicleloan.services.VehicleLoanService;

@Controller

public class ApplicationController {
	
	@Resource
	private ApplicationService service= new ApplicationServiceImpl();
	@Resource
	private LoginService service1= new LoginServiceImpl();
	
	@RequestMapping("/appForm")
	public String goToApplication(HttpSession session) 
	{
		String userName = (String)session.getAttribute("userName");
		try {
			Register user =service1.getUser(userName);
			session.setAttribute("user", user);
		} catch (VehicleLoanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "PersonalDetails";
	}
	
	@RequestMapping("/cancel")
	public ModelAndView gotoDashboard() {
		ModelAndView mv = new ModelAndView("UserDashboard");
		return mv;
	}
	
	@RequestMapping("/appform1")
	public  ModelAndView addPDetails(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("personalD") PersonalDetails pd, HttpSession session) {
		ModelAndView mv = null;
	try {
		String userName =(String) session.getAttribute("userName");
		System.out.println(pd.getEmployment());
		String dob =request.getParameter("dob");
		String[] arrDate = dob.split("-",3);
		int dobYear = Integer.parseInt(arrDate[0]);
		int dobMonth = Integer.parseInt(arrDate[1]);
		 int age = 0;
		Calendar c = Calendar.getInstance();
		 int year = c.get(Calendar.YEAR);
		 int month = c.get(Calendar.MONTH);
		 if(dobMonth > month) {
			 age = (year - dobYear) -1;
		 }
		 else
		 {
			age = year - dobYear;
		 }
		 System.out.println(age);
		 pd.setAge(age);
		 pd.setUserName(userName);
		service.addPDetails(pd);
	} catch (VehicleLoanException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	mv = new ModelAndView("VehicleLoanDetails");
		return mv;
	}
	
	@RequestMapping("/appform2")
	public  ModelAndView addLDetails(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("loanD") LoanDetails Ld) {
		ModelAndView mv = null;
	try {
		service.addLDetails(Ld);
		
	} catch (VehicleLoanException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	mv = new ModelAndView("UploadDocuments");
		return mv;
	}

}
