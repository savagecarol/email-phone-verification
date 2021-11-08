package com.example.otpweb.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.otpweb.entity.Email;
public interface EmailDao extends JpaRepository<Email, String>
{}
