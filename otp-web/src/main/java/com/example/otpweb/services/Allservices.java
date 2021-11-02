package com.example.otpweb.services;

import java.util.List;

import com.example.otpweb.entity.Email;

public interface Allservices {
	
	List<Email> getAll() ;

	Email getByEmail(String email) ;

	
	
	Email addEmail(Email email) ;
}
