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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity 
@Table (name="USER_DETAILS_Collections") 
public class UserDetailsCollections {
	
	/*For eg if we have to save all the previous address any user lived then it is
	a collecton. If we have a collection of address objects where we dont know how many a user
	has ther we will create another address table */
	
	@Id @GeneratedValue (strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	
	/* @ElementCollection this annotation will tell hibernate to treate this as
	collection and not to embedded as table but to create a seperate table
	 and it auto generates the table name with this classname ie 
	UserDetailsCollections_listOfAddresses with the foreigh key of userid 
	from userDetailsCollection Object*/
	@ElementCollection
	@JoinTable (name = "USER_ADDRESS",
			joinColumns = @JoinColumn(name="USER_ID")) // This is not manditory 
	//w/o this also it will create Address Table and the name will be the table name
	//joinColumns =@JoinColumn will change the default name of the foreign column
	//private Set<Address> listOfAddresses = new HashSet<Address>();
	/*if we have to generate a primary key for the address table set wont have any
	index so we choose arraylist. The collection interface itself is used because
	we will know it in the next tutorial 11 which is lazy and eagar loding*/
	// @CollectionId()  even though we are using hibernate all the above annotations
//	are for persistance ie jpa so even if we change the implementor all these 
//	above annotations will work provided they implement jpa but for the 
//	@CollectionId it is specific to hibernate so if we change implementor it wont work
	@GenericGenerator(name="hilo-gen", strategy = "hilo")
	@CollectionId(columns = {@Column(name="ADDRESS_ID")}, generator= "hilo-gen", type = @Type(type="long"))
	private Collection<Address> listOfAddresses = new ArrayList<Address>();
	//In the above we gave column name , and type and generator which means it will define
	//its own by using the @genericgenerator which has hilo-gen which is one kind of 
	//generator hibernate provides since address_id is not present in the address object
	//we are using this and telling hibernate to auto generate
	
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
	/*public Set<Address> getListOfAddresses() {
		return listOfAddresses;
	}
	public void setListOfAddresses(Set<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}*/
	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}
	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}
}
