package com.example.otpweb.entity;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Email {
	
	@Id
	private String email;
	private LocalDateTime generateTime;
	private LocalDateTime expiretime;
	private String otp;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getGenerateTime() {
		return generateTime;
	}

	public void setGenerateTime() {
		this.generateTime = LocalDateTime.now();
	}

	public LocalDateTime getExpiretime() {
		return expiretime;
	}

	public void setExpiretime() {

		this.expiretime = LocalDateTime.now().plus(Duration.of(10, ChronoUnit.MINUTES));
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp() {
		Random rnd = new Random();
	    int number = rnd.nextInt(999999);
	    this.otp = String.format("%06d", number);
	}

	public Email(String email) 
	{
		this.email = email;
	}
	
	Email()
	{
		
	}
}
