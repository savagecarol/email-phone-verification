package com.example.otpweb.services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.otpweb.Dao.EmailDao;
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
			sendEmail(x.getOtp());
			return x;
	}
	
	
	
	void sendEmail(String otp) 
	{
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("farazkhanv@gmail.com");
        msg.setSubject("Testing from Spring Boot");
        msg.setText("our otp    " + otp + "   expire in 10 minutes ");
        javaMailSender.send(msg);
    }
	
}
