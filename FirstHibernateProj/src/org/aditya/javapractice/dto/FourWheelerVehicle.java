package org.aditya.javapractice.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//Video 17
@Entity
//@DiscriminatorValue("CAR") // this is to tell the DTYPE value in the colum should be Bike instead  of the
//class name which is FourWheeleerVehicle.
public class FourWheelerVehicle extends VehicleInheritance{
	
	private String steeringWheel;

	public String getSteeringWheel() {
		return steeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}

}
