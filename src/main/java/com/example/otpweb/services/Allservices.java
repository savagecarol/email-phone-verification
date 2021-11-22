package com.example.otpweb.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.otpweb.Dao.EmailOtp;
import com.example.otpweb.Exception.InvalidOTPException;
import com.example.otpweb.entity.Email;


public interface Allservices {
	
	List<Email> getAll() ;

	Email getByEmail(String email) ;
	
	ResponseEntity<HttpStatus> addEmail(Email email) ;

	ResponseEntity<HttpStatus> OtpValidate(EmailOtp eo) throws InvalidOTPException;
	
}
