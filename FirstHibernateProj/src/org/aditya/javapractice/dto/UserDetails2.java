package org.aditya.javapractice.dto;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table (name="USER_DETAILS2") 
public class UserDetails2 {
	
	/*Natural key and serogate key means both are unique. For eg 
	email id should be unique is a req then if can be a serogate key. And natural
	key is like a login id which should  be unique
	In the serogate key we can ask hibernate to generate the key because we dont
	need to use the key apart from having it as a unique. We can ask hibernate 
	to create it for us by using @generatedvalue 
	this annotation has stratergy where we have control to create a serogate id
	like we can tell hibernate to create in sequence, auto etc
	*/
	
	@Id @GeneratedValue (strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	//@Embedded // another clue to hibernate but we dont need to do this
	
	/*Here we are specifying that dont use the street as column name but replace
	with the column name specified
	
	For multiple columns we need to use another anotation which is @attributeoverrides
	*/
	@AttributeOverrides({
	@AttributeOverride (name="street",column = @Column(name="HOME_STREET_NAME")),
	@AttributeOverride (name="city",column = @Column(name="HOME_CITY_NAME")),
	@AttributeOverride (name="state",column = @Column(name="HOME_STATE_NAME")),
	@AttributeOverride (name="pincode",column = @Column(name="HOME_PIN_CODE"))})
	private Address homeAddress;
	
	/*If we have to use different column names we can go to address object and 
	use @column annotation to configure the values we dont want to take as default
	but w=if there are 2 address objects say homeaddress and office address in the
	user object it will have a conflict because we need to create unique names
	for the columns. For that we have annotation @AttributeOverride which gives 
	use to congigure the column names from the userDetails2 object itself*/
	
	private Address offficeAddress;
	
	
	/* */
	
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
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOffficeAddress() {
		return offficeAddress;
	}
	public void setOffficeAddress(Address offficeAddress) {
		this.offficeAddress = offficeAddress;
	}
	
}
