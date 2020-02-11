package com.login.loginService.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the "login" database table.
 * 
 */
@Entity
@Table(name="login")
public class LoginModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="email")
	private String email;

	@Column(name="password")
	private String password;

	@Column(name="role")
	private String role;

	@Column(name="isactive")
	private char isActive;
	
	@Column (name="createdon")
	private Date createdOn;
	

	@Column (name="updatedon")
	private Date updatedOn;
	
	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public char getIsActive() {
		return isActive;
	}

	public void setIsActive(char isActive) {
		this.isActive = isActive;
	}

	public LoginModel() {
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}