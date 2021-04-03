package com.ashokit.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.entity.OtpEntity;
import com.ashokit.service.EmailServiceImpl;
import com.ashokit.service.IEmailService;

@RestController
public class EmailController {
	
	@Autowired
	private IEmailService service;
	
	@GetMapping("/sendEmail")
	public ResponseEntity<String> sendEmail() throws Exception
	{
		String subject="apply for java Developer";
		String to="vijayjumbad2016@gmail.com";
		//String body="regarding java job";
		boolean sendEmail = service.sendEmail(subject, to,generateOTP());
		return new ResponseEntity<String>("email sending is successfully",HttpStatus.OK);
		
	}
	
	 public static String generateOTP() 
	    {  
	        int randomPin   =(int) (Math.random()*9000)+1000;
	        String otp  = String.valueOf(randomPin);
	        return otp; //returning value of otp
	    }
	
	 @PostMapping("/saveOtp")
	 public String saveOpt(@RequestBody OtpEntity otpEnitty)
	 {
		 String saveOtp = service.saveOtp(otpEnitty);
		 if(saveOtp!=null)
		return "otp saved successfully";
		 else
			 return "otp not saved successfully";
		 
	 }
	 @GetMapping("/getotp")
	 public ResponseEntity<String> getOtp(@RequestParam("otp")int otp)
	 {
		 OtpEntity result = service.getOtp(otp);
		 if(result!=null)
		return new ResponseEntity<String>("otp feched successfull ", HttpStatus.OK);
		 else
			 return new ResponseEntity<String>("otp not feched successfull ", HttpStatus.BAD_REQUEST);
		 
		 
	 }

}
