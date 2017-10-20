package org.aditya.javapractice.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//Video 17
@Entity
//@DiscriminatorValue("BIKE") // this is to tell the DTYPE value in the colum should be Bike instead  of the
//class name which is twoWheeleerVehicle.
public class TwoWheelerVehicle extends VehicleInheritance{
	
	private String steeringHandle;

	public String getSteeringHandle() {
		return steeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}

}
