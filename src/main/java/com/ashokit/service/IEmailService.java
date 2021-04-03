package com.ashokit.service;

import com.ashokit.entity.OtpEntity;

public interface IEmailService {
	
	public boolean sendEmail(String subject,String to,String body) throws Exception;
	
	public String saveOtp(OtpEntity otp);
	public OtpEntity getOtp(int otp);

}
