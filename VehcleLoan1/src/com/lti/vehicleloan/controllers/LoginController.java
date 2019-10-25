package com.lti.vehicleloan.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.lti.vehicleloan.beans.*;
import com.lti.vehicleloan.exceptions.VehicleLoanException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.lti.vehicleloan.services.LoginService;
import com.lti.vehicleloan.services.LoginServiceImpl;

@Controller
public class LoginController {

	@Resource
	private LoginService service= new LoginServiceImpl();
	
	@RequestMapping("/getUserList")
	public  ModelAndView getUserList(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	String uName=(String) session.getAttribute("userName");
	List<Register> appList =null;
	try {
		appList = service.getAppList();
		System.out.println(appList);
	} catch (VehicleLoanException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	session.setAttribute("appList", appList);
		ModelAndView mnv = null;
		//mnv.addObject("appList", appList);
		mnv = new 	ModelAndView("DisplayAllUsers");
	return mnv;
	}
	
	@RequestMapping("/getApplicationList")
	public ModelAndView getApplicationList(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		ModelAndView mnv = null;
		List<PersonalDetails> pd =null;
		try {
			pd=service.getApplicationList();
			 boolean check = pd.isEmpty();
			 if(check) {
				 mnv.addObject("message", "this User has no application");
				 mnv = new 	ModelAndView("ApplicationDetails");
				 return mnv;
			 }} catch (VehicleLoanException e) {
				
					e.printStackTrace();
				}
		session.setAttribute("pdList",pd);
		mnv = new 	ModelAndView("ApplicationDetails");
			 return mnv;
	}
	
	@RequestMapping("/allDetails")
	public  ModelAndView getAllDetails(HttpServletRequest request, HttpServletResponse response,HttpSession session,
			@RequestParam(value="uName")String uName ,
	@RequestParam(value="applicationId") int applicationId){
		ModelAndView mnv = null;
		PersonalDetails pd =null;
		Register user =null;
		LoanDetails loanDetails=null;

		try
		{
		user= service.getUser(uName);//register se aayega
		System.out.println(user);
		session.setAttribute("user",user);
		 pd =service.getApplicantDetails(applicationId);//personaldetails se aayega
		 System.out.println(pd);
		 session.setAttribute("pd",pd);
		 loanDetails=service.getLoanDetails(applicationId);//loandetails se aayega
		 System.out.println(loanDetails);
		 session.setAttribute("loanDetails",loanDetails);
		}
		catch(VehicleLoanException e)
		{
			e.printStackTrace();
		}

		mnv = new 	ModelAndView("DisplayDetails");
	
	return mnv;
}
	@RequestMapping("/getApprovedApplications")
	public ModelAndView getApprovedApplication(HttpServletRequest request,HttpSession session) {
		ModelAndView mnv = new ModelAndView();
		List<StatusDetails> sd= null;
		try {
			sd = service.getApprovedApplication();
		} catch (VehicleLoanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("approved", sd);
		mnv.setViewName("approvedApplication");
		return mnv;
	}
	
	@RequestMapping("/getRejectedApplications")
	public ModelAndView getRejectedApplication(HttpServletRequest request,HttpSession session) {
		ModelAndView mnv = new ModelAndView();
		List<StatusDetails> sd=null;
		try {
			sd = service.getRejectedApplication();
		} catch (VehicleLoanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("rejected", sd);
		mnv.setViewName("rejectedApplication");
		return mnv;
	}
	/*@RequestMapping("/appDetails")
	public  ModelAndView getApplicationDetails(HttpServletRequest request, HttpServletResponse response,HttpSession session,@RequestParam("uName")String uName) {
		//String uName=request.getParameter("userName");
		ModelAndView mnv = null;
		List<PersonalDetails> pd =null;
		try {
			 pd =service.getAppDetails(uName);
			 boolean check = pd.isEmpty();
			 if(check) {
				 mnv.addObject("message", "this User has no application");
				 mnv = new 	ModelAndView("ApplicationDetails");
				 return mnv;
			 }
		} catch (VehicleLoanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("pdList",pd);
		//mnv.addObject("appList", appList);
		System.out.println(pd);
		mnv = new 	ModelAndView("ApplicationDetails");
		return mnv;
	}*/
	
	
	@RequestMapping("/approveApplication")
	public ModelAndView approveApplication(HttpServletRequest request,HttpSession session){
		ModelAndView mnv = new ModelAndView();
		PersonalDetails pd=(PersonalDetails) session.getAttribute("pd");
		LoanDetails loan=(LoanDetails) session.getAttribute("loanDetails");
		Double loanAmount = loan.getLoanAmount();
		int tenure = loan.getLoanTenure();
		float roi =loan.getROI();
		String status =request.getParameter("status");
		Double emi=0.0;
		Double loanA=0.0;

		if(status=="Approve") {
		roi=roi/(12*100);
		emi= (loanAmount*roi*( (Math.pow(1+roi,tenure))/ ((Math.pow(1+roi,tenure)-1))));
		loanA=loanAmount;
		}
		
		StatusDetails sd= new StatusDetails();
		
		sd.setUserName(pd.getUserName());
		sd.setApplicationId(pd.getApplicationId());
		sd.setLoanId(loan.getLoanId());
		sd.setStatus(status);
		sd.setDescription(request.getParameter("description"));
		sd.setDateofApproval(new Date(new java.util.Date().getTime()));
		sd.setLoanAmount(loanA);
		sd.setEmi(emi);
		System.out.println(emi);
		System.out.println(sd);
		try {
			service.addStatusDetails(sd);
			session.setAttribute("sd", sd);
		} catch (VehicleLoanException e) {
			mnv.addObject("message", "This Application is already processed");
			mnv.setViewName("Error");
		}
		mnv.setViewName("AdminDashboardPage");
		return mnv;
	}
	
	@RequestMapping("/myApplication")
	public ModelAndView getMyApplications(HttpServletRequest request,HttpSession session) {
		
		String userName =(String) session.getAttribute("userName");
		ModelAndView mnv= null;
		List<StatusDetails> sd=null;
		try {
		sd = service.getMyApplications(userName);
		} catch (VehicleLoanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("sd",sd);
		 mnv = new 	ModelAndView("MyApplication");
		 return mnv;
	}
	
	@RequestMapping("/viewApplication")
	public ModelAndView viewApplication(HttpServletRequest request,HttpSession session,@RequestParam("uName")String uName,@RequestParam("appId")int appId) {
		ModelAndView mnv = new ModelAndView();
		PersonalDetails pd =null;
		Register user =null;
		LoanDetails loanDetails=null;
		StatusDetails sd=null;
		try {
			user= service.getUser(uName);
			 pd =service.getApplicantDetails(appId);
			 loanDetails=service.getLoanDetails(appId);
			sd=service.getStatus(appId);
		} catch (VehicleLoanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("user",user);
		session.setAttribute("pd",pd);
		session.setAttribute("loanDetails",loanDetails);
		session.setAttribute("sd",sd);
		mnv.setViewName("userApplication");
		return mnv;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "Home";
	}
}

