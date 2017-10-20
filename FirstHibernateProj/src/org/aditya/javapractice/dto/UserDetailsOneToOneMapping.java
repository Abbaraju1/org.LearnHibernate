package org.aditya.javapractice.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
//Entity inside entity
@Entity 
@Table (name="USER_DETAILS_OnetoOne") 
public class UserDetailsOneToOneMapping {
	
	//Video 13
	@Id @GeneratedValue (strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	
	/*For a Entity to Entity mapping Unlike the previous example we wont use embedeble like 
	for address in the previous example but we use a differen set of annotations for this 
	based on the mapping relationships. weather it is a onetoone mapping or onetomany etc
	And we just have to set the user the vehicle object in the HibernateTest3 class and thats it
	if we run it creates a new column in the user details one to one table which is 
	vehicle_vehicleId which maps to the vehicle entity 
	*/
	@OneToOne
	@JoinColumn(name="VEHICLE_ID") // Id we dont want the default column name then we need to use
	//@JoinColumn(name=" our name ")  annotation to change the name
	private VehicleOneToOneMapping vehicle;
	
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
	public VehicleOneToOneMapping getVehicle() {
		return vehicle;
	}
	public void setVehicle(VehicleOneToOneMapping vehicle) {
		this.vehicle = vehicle;
	}
}
