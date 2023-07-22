package com.qci.ecommercewebapp.Service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qci.ecommercewebapp.Model.User;
import com.qci.ecommercewebapp.Repository.UserRepo;

@Service
public class UserService {

	@Autowired private UserRepo userRepo;
	
	public Optional<User> findByUsername(String  username){
		return userRepo.findByUsername(username);
	}
}
