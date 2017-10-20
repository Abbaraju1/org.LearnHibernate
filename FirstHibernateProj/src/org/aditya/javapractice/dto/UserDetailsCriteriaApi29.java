package org.aditya.javapractice.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/*Named queries : are the queries where we prefer to write the common 
query at one place ie entity level so that we can use it anywhere 
in the application. For eg : all tthe user related queries in the 
User entity
 */

@Entity 
//Reason for this name is we want a query where a query can be supplied by Id and
//get the user details object ( good practice is to write the Entity name follewed
//byId ie the query so that we can easily identify) and then follwed by the query.
//Test using HibernateHQLNamedQueries28
@NamedQuery(name="UserDetails.byId", query="from UserDetailsNamedQueries28 where userId = ?")
/*We can also write a regular SQL query and it works based on the Table Name and not 
the Class Name. Since Hibernate only takes entity which is the class. The way we
can implement is using @@NamedNativeQuery
*/
@NamedNativeQuery(name="UserDetails.byName", query="select * from USER_DETAILS_NamedQueries where userName = ?", resultClass=UserDetailsCriteriaApi29.class)
//if you observer the query is completely in SQL
//In NativeSQLQuery we are supposed to specify the class name to caste. In NamedQueries Hibernate will automatically
//know what object to caste to but in NamedNativeQuery Hibernate wont know. So we add the class name at the end.
@Table (name="USER_DETAILS_NamedQueries")  
public class UserDetailsCriteriaApi29 {
	
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
