package com.example.otpweb.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.otpweb.entity.PhoneNumber;

public interface NumberDao extends JpaRepository<PhoneNumber, String>
{}
