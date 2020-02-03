package com.student.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="studentaddress")
public class StudentAddress {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="address_seq")
	@Column(name="id")
	private int id;
	
	
	@OneToOne
	@JoinColumn(name = "studentid",referencedColumnName = "id",nullable=false)
	private Student student;
	
	@Column(name="streetname")
	private String streetName;
	
	@Column(name="City")
	private String City;

	@Column(name="country")
	private String country;
	
	@Column(name="zipcode")
	private String zipcode;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public Student getStudentId() {
		return student;
	}
	public void setStudentId(Student student) {
		this.student = student;
	}
	
	

}
