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
import javax.persistence.ManyToMany;
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
public class UserDetailsManyToMany {
	
	//Video 15 manytomany relationships ( rental car - one user can have multiple  and one car 
	//can have multiple. here a mapping table is compulsaru which is the 3rd table created 
	//By hibernate to map the user primary key and the vehicle primary key
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	
	@ManyToMany
	@JoinTable(name="USER_VEHICLE", joinColumns=@JoinColumn(name="USER_ID"),
						inverseJoinColumns=@JoinColumn(name="VEHICLE_ID"))
	private Collection<VehicleManyToMany> vehicle = new ArrayList<VehicleManyToMany>();
	
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
	public Collection<VehicleManyToMany> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<VehicleManyToMany> vehicle) {
		this.vehicle = vehicle;
	}
}
