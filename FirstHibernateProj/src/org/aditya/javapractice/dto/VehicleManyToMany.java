package org.aditya.javapractice.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

//Entity inside entity
@Entity
public class VehicleManyToMany {
	@Id @GeneratedValue
	private int vehicleId;
	private String vehicleName;
	
	//Even here if we use mappedBy hibernate wont use 2 different tables to map 2 ways ie bidirectionaly
	//but will tell hibernate it is mpped by the user details many to many class
	@ManyToMany(mappedBy="vehicle") 
	private Collection<UserDetailsManyToMany> userList = new ArrayList<UserDetailsManyToMany>();
	 
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public Collection<UserDetailsManyToMany> getUserList() {
		return userList;
	}
	public void setUserList(Collection<UserDetailsManyToMany> userList) {
		this.userList = userList;
	}

}
