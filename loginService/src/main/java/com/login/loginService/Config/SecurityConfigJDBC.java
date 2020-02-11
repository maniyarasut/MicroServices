package com.login.loginService.Config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;


public class SecurityConfigJDBC extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource dataSource;
	
	@Override
	public void configure (AuthenticationManagerBuilder auth) throws Exception
	{
		auth
		.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select email,password,enabled from login where email =?");
		
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
