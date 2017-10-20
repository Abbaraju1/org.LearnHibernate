package org.aditya.hibernate;

import java.util.Date;
import java.util.List;

import org.aditya.javapractice.dto.UserDetails;
import org.aditya.javapractice.dto.UserDetails1;
import org.aditya.javapractice.dto.UserDetailsNamedQueries28;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class HibernateHQLNamedQueries28 {
// Note no class is created for this in DTO
	public static void main(String[] args) {
	
		/*//Do this and make change in the hibernate.cfg.xml to UPDATE from create
		for(int i =1; i<=10; i++){
			UserDetailsNamedQueries28 user = new UserDetailsNamedQueries28();
			user.setUserName("User " +i);
		}*/
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//for NamedQuery
		//Query query = session.getNamedQuery("UserDetails.byId");
		//query.setInteger(0, 2);
		
		//For NamedNativeQuery  ( we can use either ) 
		Query query = session.getNamedQuery("UserDetails.byName");
		query.setString(0, "User 10");
		List<UserDetailsNamedQueries28> users = (List<UserDetailsNamedQueries28>) query.list();

		session.getTransaction().commit();
		session.close();
		users.forEach(u -> System.out.println(u.getUserName())); //java 8 for each
		
	}

}
