package org.aditya.javapractice.dto;

import javax.persistence.Embeddable;

@Embeddable //This annotation tells hibernate it is a value object and we need
//not create a seperate table for this  
public class Address {
	/*Value object means if we treat this address fields same as the columns
	in the userdetails2 object meaning we create columns for all the userDetails2
	object as well as the address object in one table and w/o considering the 
	address object as a seperate object.
	value Object means it contails data that we need to save to the database
	but it has meaning of another object that is street of userDetails object etc
	Entity Object means it contains data that provides meaning to itself*/

	private String street;
	private String city;
	private String state;	
	private String pincode;
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
}
