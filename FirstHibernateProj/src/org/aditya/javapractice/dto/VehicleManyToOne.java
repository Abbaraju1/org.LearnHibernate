package org.aditya.javapractice.dto;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//Entity inside entity
@Entity
public class VehicleManyToOne {
	@Id @GeneratedValue
	private int vehicleId;
	private String vehicleName;
	
	//We are creating a reverse  relationship that is manytoone which means every vehicle 
	// will have a USER. So lets create the member variabe
	
	@ManyToOne
	private UserDetailsOneToMany user;
	 
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
	public UserDetailsOneToMany getUser() {
		return user;
	}
	public void setUser(UserDetailsOneToMany user) {
		this.user = user;
	}

}
