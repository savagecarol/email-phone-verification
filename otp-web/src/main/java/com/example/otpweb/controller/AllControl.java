package com.example.otpweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.otpweb.entity.Email;
import com.example.otpweb.services.Allservices;


@RestController
public class AllControl 
{
	
	@Autowired
	private Allservices AllServices;
	
	@GetMapping("/home")
	public String home() 
	{
		return "bbpopopooo";
	}
	


	@GetMapping("/email")
	public List<Email> getAll() {
		return AllServices.getAll();	
	}

	@GetMapping("/email/{email}")
	public Email getByEmail(@PathVariable String email) 
	{
		return AllServices.getByEmail(email);
	}
	
	@PostMapping("/email")
	public Email addEmail(@RequestBody Email email) 
	{
		email.setGenerateTime();
		email.setExpiretime();
		email.getOtp();
		return AllServices.addEmail(email);
	}
}
