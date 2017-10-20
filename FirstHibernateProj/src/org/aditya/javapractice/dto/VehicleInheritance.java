package org.aditya.javapractice.dto;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
/* First Stratergy which is default : Single Table Stratergy
 @Inheritance(strategy=InheritanceType.SINGLE_TABLE) // this is not mandetory since hibernate by default uses single table stratergy.
@DiscriminatorColumn(name="Vehicle_Type",
					discriminatorType=DiscriminatorType.STRING) // if we use the discriminatorannotation we
//can change the default name as DType and make it vehicle_type
*/

/* 2nd : Table per class Stratergy
 @Inheritance(strategy=InheritanceType.TABLE_PER_CLASS) // This is all is required to implement a table per class
Stratergy but if we dont specify anything then hibernate by default will use Single table Stratergy. 
Even if it has seperate tables all the fields in the parent class is created in the child class as columns 
and if it has an id which is generated value by hibernate. Even the child class id values will be generated 
Advantage of this stratergy is we dont need a dtype and 2nd thing is it is in the normalised form*/

/*3rd stratergy :  Joined Stratergy
This is what we need to change by changing the inheritanceType.
Now in the previous stratergy all the fields of the base class are also created in the class which extends
The base class ie even a fourwheeler or a twowheeler table has id and name columns. By this we can eliminate
that. So what joined does is in the vehicle colum itself it will create the id and values for the super
classes ie fourwheeler and twowheeler.
Twowheeler and Fourwheeler tables will have only its property and the id. Since this is a join property can use
the join property to join the vehicle and fourWheeler or twoWheeler
select * from vehicle join fourwheeler on vehicle.veicleid = fourwheeler.vehicleid is the query 
*/
@Inheritance(strategy=InheritanceType.JOINED) 
public class VehicleInheritance {
	@Id @GeneratedValue
	private int vehicleId;
	private String vehicleName;
	 
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

}
