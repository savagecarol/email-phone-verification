package com.example.otpweb.services;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.otpweb.Dao.EmailDao;
import com.example.otpweb.Dao.EmailOtp;
import com.example.otpweb.entity.Email;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;



@Service
public class AllservicesImpl implements Allservices {
	
	@Autowired
	private EmailDao emailDao;
	

	@Autowired
    private JavaMailSender javaMailSender;
	
	
	@Override
	public List<Email> getAll() {
		return emailDao.findAll();
	}

	@Override
	public Email getByEmail(String email) {
		return emailDao.findById(email).orElse(null);
	}

	@Override
	public Email addEmail(Email email)
	{
			Email x =  emailDao.save(email);
			sendEmail(email.getEmail() , email.getOtp());
			return x;
	}
	
	
	
	void sendEmail(String email  ,  String otp) 
	{
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);
        msg.setSubject("Testing from Spring Boot");
        msg.setText("our otp    " + otp + "   expire in 10 minutes ");
        javaMailSender.send(msg);
    }

	@Override
	public boolean OtpValidate(EmailOtp eo) {
		
		Email emailData = getByEmail(eo.getEmail());
		if(emailData == null) 
			{
				System.out.print("SDFdsf");
				return false;
			}
		else 
		{
			if(emailData.getOtp().equals(eo.getOtp()))
			{
				LocalDateTime start = emailData.getGenerateTime();
				LocalDateTime end = emailData.getExpiretime();
				LocalDateTime curr = LocalDateTime.now();
				System.out.println(ChronoUnit.MINUTES.between(curr , end));
				if(ChronoUnit.MINUTES.between(curr , start) > 0 && ChronoUnit.MINUTES.between(curr , start) < 0)
					{
						return true;
					}
				return false;
			}
			return false;
		}
	}
	
}
