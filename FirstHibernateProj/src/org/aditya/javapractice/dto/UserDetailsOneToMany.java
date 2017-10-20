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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
//Entity inside entity
@Entity 
@Table (name="USER_DETAILS_OnetoOne") 
public class UserDetailsOneToMany {
	
	//Video 14 here we see 2 mappings onetomany and manytoone relationships
	//A user can have any vehicles onetomany relationship
	//Any number of vehicles can have one User manytoone relationship
	@Id @GeneratedValue (strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	
	@OneToMany
	/* So what hibernate does is it takes the user details primary key and vehicle
	details primary key and creates a new table called user_details_vehicle which has 2 columns 
	user_details_userid , vehicle_vehicleId which will have 2 rows  1 mapped to 2 and 1 mapped to 3
	 which is 1 user and 2 vehicles
	This is for the 3 rd table which is created by the hibernate we can change the name of the table
	as well as the column names of the table with these annotations w/o using defaults
	 This annotation is option if we dont use hibernate takes the defaults*/
	@JoinTable(name="USER_VEHICLE", joinColumns=@JoinColumn(name="USER_ID"),
						inverseJoinColumns=@JoinColumn(name="VEHICLE_ID"))
	private Collection<VehicleManyToOne> vehicle = new ArrayList<VehicleManyToOne>();
	
	/*To take advantage we can create a user object in the vehicle class which is a manytoone
	relationship and will make hibernate map an vehicle to one user and which will eliminate
	creating a 3rd table which has both the primany keys
	
	@OneToMany(mappedBy="user") which will tell user to map it based on the user on the vehicle class
	private Collection<VehicleManyToOne> vehicle = new ArrayList<VehicleManyToOne>();
	
	@ManyToOne
	@JoinColumn(name="USER_ID") // by giving this in the vehicle it should be good to skip the 
	//table created by hibernate and hibernate creates a seperate column in the vehicle table itself
	private UserDetailsOneToMany user;
	*/
	
	
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
	public Collection<VehicleManyToOne> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<VehicleManyToOne> vehicle) {
		this.vehicle = vehicle;
	}
}
