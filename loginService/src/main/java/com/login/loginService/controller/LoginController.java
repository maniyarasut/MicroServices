package com.login.loginService.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.loginService.models.AuthenticationRequest;
import com.login.loginService.models.AuthenticationResponse;
import com.login.loginService.models.LoginDto;
import com.login.loginService.models.LoginModel;
import com.login.loginService.service.LoginService;
import com.login.loginService.service.MyUserDetailsService;
import com.login.loginService.util.JwtTokenUtil;

@RestController
@RequestMapping
public class LoginController {

	@Autowired
	LoginService service;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticate(@Valid @RequestBody AuthenticationRequest authenticateRequest) throws Exception
	{
		try {
		authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(authenticateRequest.getUserName(), authenticateRequest.getPassword()));
		}
		catch (Exception ex)
		{
			throw new Exception("Invalid Login");
		}
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(authenticateRequest.getUserName());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
		
	}

	@PostMapping("/signup")
	public String createLogin( @Valid @RequestBody LoginDto login) {
		return service.createLogin(login);
	}
	
	@PutMapping("/updateLogin")
	public String updateLogin(@RequestBody LoginModel login) {
		return service.upDateLogin(login);
	}
	
	@GetMapping("/hello")
	public String getAll()
	{
		return "Hello:):)";
	}
}

