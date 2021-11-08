package com.example.otpweb.entity;


import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PhoneNumber {
	
	@Id
	String number;
	LocalDateTime generateTime;
	LocalDateTime expiretime;
	String otp;
	
	public PhoneNumber(String number, String otp) {

		this.number = number;
		this.generateTime = LocalDateTime.now();
		this.expiretime = LocalDateTime.now().plus(Duration.of(10, ChronoUnit.MINUTES));
		this.otp = otp;
	}
}
