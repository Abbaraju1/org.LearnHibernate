package org.aditya.javapractice.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity //(name="USER_DETAILS") // if we dont pass this property then hibernate will
//by default take the class name as the table name
public class UserDetails {
	
	//We can also use the annotations of the field on top of getters in which case
	//it picks up the value from getter

	@Id // this is used to give primary key 
	@Column (name="USER_ID")
	private int userId;
	// if we want to change the column name then we need to use @Column annotation 
	// to override the field name. If we dont use this then hibernate will by 
	// default take the field name
	@Column (name="USER_NAME")
	private String userName;
	
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
}
