package com.login.loginService;

import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

	@Autowired
	LoginRepo repo;

	public String createLogin(LoginDto dto) {
		LoginModel login = new LoginModel();
		login.setEmail(dto.getEmail());
		login.setPassword(dto.getPassword());
		login.setRole(dto.getRole());
		login.setCreatedOn(new Date(System.currentTimeMillis()));
		login.setUpdatedOn(new Date(System.currentTimeMillis()));
		login.setIsActive('Y');
		repo.save(login);
		return login.getEmail() + " account has been created successfully";
	}

	public String upDateLogin(LoginModel login)
	{
		
		Optional<LoginModel> loginUser = repo.findById(login.getEmail());
		if(loginUser.isPresent())
		{
			login.setUpdatedOn(new Date(System.currentTimeMillis()));
			repo.save(login);
			return login.getEmail()+" account has been updated successfully";
		}
		else
			return "Invalid emailId";
	}

	public Boolean validateLogin(@Valid LoginDto dto) {
		
		Optional<LoginModel> login = repo.findById(dto.getEmail());
		if (login.isPresent() && login.get().getIsActive()=='Y') {
			if(login.get().getPassword().equals(dto.getPassword()));
				return true;
		}
		else
			return false;
	}
}
