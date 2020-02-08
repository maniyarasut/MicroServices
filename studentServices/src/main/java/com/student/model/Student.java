package com.student.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1774267133863374078L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="student_seq")
	@Column(name ="id")
	private int id;
	
	@Column(name ="name")
	private String name;
	
	
	@Column(name ="email")
	private String email;
	
	@Column(name="DOB")
	private Date dateOfBirth;
	
	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="addressid")
	private StudentAddress address;
	
	
	public StudentAddress getAddress() {
		return address;
	}
	public void setAddress(StudentAddress address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	

}
