package org.aditya.javapractice.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity 
@Table (name="USER_DETAILS1") // Read UserDetails.java first
// In the previous one we used name for entity which means it is used
// for the complete entity and if we use the table annotation then the name
// is used for the table only and the entity remains the class name
// The difference is better understood in the HQL queries 
public class UserDetails1 {
	
	/*If we dont specify anything then hibernate will automatically create the data
	types for these fields in the table.*/
	
	@Id
	private int userId;
	//@Transient // if we dont want this property saved we us this annotation
	// we can also use static to ignore this field
	private String userName;
	
	/*Hibernate will by default will save the date with the timezone in the db.
	But if we want it to save only the date w/o the time then we use this annotation
	@Temporal(TemporalType.DATE)*/
	private Date joinedDate;
	private String address;
	
	/*Hibernate will bydefault use a varchar of 255 characters for all strings if
	we dont specify anything but if we want he description to be more than that
	and we dont know the size then we use annotation @Lob if it is a string
	meaning a character array then hibernates uses clob automatically and if
	if a byte array hibernate uses @blog automatically. we dont need to make 
	changes
	@Lob*/
	private String description; 
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
