package com.ashokit.service;

import java.util.Optional;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.ashokit.entity.OtpEntity;
import com.ashokit.repository.OtpRepo;
@Service
public class EmailServiceImpl implements IEmailService {
	@Autowired
	private JavaMailSender sender;
	
	@Autowired
	private OtpRepo repo;

	@Override
	public boolean sendEmail(String subject, String to, String body) throws Exception {
		MimeMessage msg = sender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(msg, true);

		helper.setTo(to);

		helper.setSubject(subject);

		helper.setText(body, true);
		

		sender.send(msg);
		return true;
	}
	@Override
	public String saveOtp(OtpEntity otp) {
		 OtpEntity save = repo.save(otp);
		return  save!=null ? "Otp not saved":"Otp is saved";
	}
	
	@Override
	public OtpEntity getOtp(int otp) {
		OtpEntity findByOtp = repo.findById(otp).get();
		return findByOtp;
		
	}

}
