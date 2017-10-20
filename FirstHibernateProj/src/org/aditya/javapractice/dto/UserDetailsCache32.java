package org.aditya.javapractice.dto;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity 
@Cacheable 
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@NamedQuery(name="UserDetails.byId", query="from UserDetailsCache32 where userId = ?")
@Table(name="User_Details_Cache32")
@org.hibernate.annotations.Entity(selectBeforeUpdate=true)
public class UserDetailsCache32 {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	
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
}
