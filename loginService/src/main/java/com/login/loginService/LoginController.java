package com.login.loginService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pauth")
public class LoginController {

	@Autowired
	LoginService service;
	

	@PostMapping("/signup")
	public String createLogin( @Valid @RequestBody LoginDto login) {
		return service.createLogin(login);
	}
	
	@PutMapping
	public String updateLogin(@RequestBody LoginModel login) {
		return service.upDateLogin(login);
	}
	
	@GetMapping
	public String getAll()
	{
		return "Hello:):)";
	}
}

