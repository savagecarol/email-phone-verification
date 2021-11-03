package com.example.otpweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.otpweb.Dao.EmailOtp;
import com.example.otpweb.entity.Email;
import com.example.otpweb.services.Allservices;



@RestController
public class AllControl 
{
	
	@Autowired
	private Allservices AllServices;
	
	@CrossOrigin
	@GetMapping("/home")
	public String home() 
	{
		return "bbpopopooo";
	}
	

	@CrossOrigin
	@GetMapping("/email")
	public List<Email> getAll() {
		return AllServices.getAll();	
	}

	@CrossOrigin
	@GetMapping("/email/{email}")
	public Email getByEmail(@PathVariable String email) 
	{
		return AllServices.getByEmail(email);
	}
	
	@CrossOrigin
	@PostMapping("/email")
	public Email addEmail(@RequestBody Email email) 
	{
		System.out.print(false);
		email.setGenerateTime();
		email.setExpiretime();
		email.setOtp();
		return AllServices.addEmail(email);
	}
	
	
	@CrossOrigin
	@PostMapping("/otp-validate")
	public boolean otpValidate(@RequestBody EmailOtp eo) 
	{
		return AllServices.OtpValidate(eo);
	}
}
