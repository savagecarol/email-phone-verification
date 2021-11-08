package com.example.otpweb.Dao;

public class EmailOtp {

	private String email;
	private String otp;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public EmailOtp(String email, String otp) {
		super();
		this.email = email;
		this.otp = otp;
	}
	public EmailOtp() {
		super();
	}
	
}
