package com.qci.ecommercewebapp.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qci.ecommercewebapp.Model.Admin;
import com.qci.ecommercewebapp.Repository.AdminRepo;

@Service
public class AdminService {

	@Autowired private AdminRepo adminRepo;
	
	 public Optional<Admin> findByUsername(String username) {
	        return adminRepo.findByUsername(username);
	    }

	public boolean checkedPassword(String password, String password2) {
		return password.equals(password2);
	}
	 
	
}
