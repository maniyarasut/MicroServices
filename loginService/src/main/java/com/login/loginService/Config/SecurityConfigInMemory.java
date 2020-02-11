package com.login.loginService.Config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


public class SecurityConfigInMemory  extends WebSecurityConfigurerAdapter{
	
	@Override
	public void configure (AuthenticationManagerBuilder auth) throws Exception
	{
		auth
		.inMemoryAuthentication()
		.withUser("user")
		.password("password")
		.roles("ADMIN");
		
	}
	
	@Override
	public void configure (HttpSecurity http) throws Exception
	{
		http.authorizeRequests()
		.antMatchers("/login").permitAll()
		.antMatchers("/login/*").hasRole("ADMIN")
		.antMatchers("/").authenticated()
		.and().formLogin();
		
	}

}
