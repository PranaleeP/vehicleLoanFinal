package com.lti.vehicleloan.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.lti.vehicleloan.beans.DocumentsUpload;
import com.lti.vehicleloan.beans.Register;
import com.lti.vehicleloan.exceptions.VehicleLoanException;
import com.lti.vehicleloan.services.ApplicationService;
import com.lti.vehicleloan.services.ApplicationServiceImpl;
import com.lti.vehicleloan.services.VehicleLoanService;
import com.lti.vehicleloan.services.VehicleLoanServiceImpl;
/*
 * http://localhost:8093/VehcleLoan1/home
 */

@Controller
public class VehicleLoanController {
	
	@Resource
	private VehicleLoanService services= new VehicleLoanServiceImpl();
	
	@RequestMapping("/home")
	public String getHomePage() 
	{
		return "Home";
	}
	
	@RequestMapping("/index")
	public String indexPage(HttpSession session) 
	{
		session.invalidate();
		return "index";
	}
	
	@RequestMapping("/checkE")
	public String getcheckPage() 
	{
		return "CheckEligibility";
	}
	
	@RequestMapping("/checkEligibility")
	public ModelAndView getEligibility(HttpServletRequest request) {
		ModelAndView mnv ;
		try {
			boolean status =services.getEligibility(request);
			if(status)
			{
				mnv = new ModelAndView("SuccessInsert");
				mnv.addObject("message", "you are eligible");
				return mnv;
			}
			
		} catch (VehicleLoanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mnv = new ModelAndView("SuccessInsert");
		mnv.addObject("message", "you are not eligible");
		return mnv;
	}
	
	@RequestMapping("/about")
	public String aboutUsPage() 
	{
		
		return "AboutUs";
	}
	
	@RequestMapping("/registerPage")
	public String getRegisterPage() 
	{
		return "Register";
	}
	@RequestMapping("/login")
	public String LoginPage() 
	{
		return "Login";
	}
	@RequestMapping("/register")
	public  ModelAndView registerUser(HttpServletRequest request,HttpSession session,@ModelAttribute("registerD") Register rd) {
		ModelAndView mnv=new ModelAndView();
		
		try {
			Register reg = services.addUser(request,rd);
			if (reg==null) {
				mnv.addObject("message", "Username or Email already exists");
				mnv.setViewName("Register");
				return mnv;
			}
		} catch (VehicleLoanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mnv.addObject("message","Successfully Registered");
		mnv.setViewName("Login");
		return mnv;
	}
	
	@RequestMapping("/rlogin")
	public  ModelAndView loginUser(HttpServletRequest request,HttpSession session) {
		ModelAndView mnv=null;
		String userName= request.getParameter("userName");
		String password=request.getParameter("password");
        if(userName.equals("admin")&&password.equals("admin"))
        { 
        	session.setAttribute("userName",userName);
        	mnv =new ModelAndView("AdminDashboardPage");
        	return mnv;
        }else {
			try {
				boolean verify=services.loginuser(request);
				System.out.println(verify);
				if(verify)
				{
					session.setAttribute("userName",userName);
					mnv =new ModelAndView("UserDashboard");
					return mnv;
				}
			}
			 catch (VehicleLoanException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        mnv =new ModelAndView("Login");
        mnv.addObject("message"," Bad Credentails!!please enter correct username and password / Unregistered user!! Please Register yourself");
         return mnv;
	}

@RequestMapping("/emiCalculatorPage")
	public String calculateEmiPage() 
	{
		
		return "CalculateEMI";
	}
	
	@RequestMapping("/emiCalculator")
	public String calculateEMI(HttpServletRequest request) 
	{
	
		try {
			services.calculateEMI(request);
		} 
	catch (VehicleLoanException e)
		{
			e.printStackTrace();
			
		}

		return "CalculateEMI";
	}
	
	/*@RequestMapping("/documentsUploadPage")
	public String documentsUploadPage() 
	{
		
		return "UploadDocuments";
	}*/
	@RequestMapping("/documentsUploadPage")
	public String documentsUploadPage() 
	{
		
		return "UploadDocuments";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	 public String uploadMultipleFileHandler(@RequestParam("files") MultipartFile[] files,HttpSession session) {
		
		String userName=(String) session.getAttribute("userName");
		String[] names= {"photo.jpg","aadhar.pdf","pan.pdf","salary.pdf"};
		if (files.length != names.length)
			return "Mandatory information missing";
		
		String message = "";
		for (int i = 0; i < files.length; i++) {
			MultipartFile file = files[i];
			String name = userName+"-"+file.getOriginalFilename();
			try {
				byte[] bytes = file.getBytes();

				System.out.println(System.getProperty("catalina.home"));
				String rootPath = "d:\\upload\\";
				// Creating the directory to store file
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				/*message = message + "You successfully uploaded file=" + name
						+ "<br />";*/
			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		}
		return "UserDashboard";
	}
	
	}

