package com.student.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="studentaddress")
public class StudentAddress implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4989194582956340146L;


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="address_seq")
	@Column(name="id")
	private int id;
	
	
	@Column(name="streetname")
	private String streetName;
	
	@Column(name="city")
	private String city;

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
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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


}
