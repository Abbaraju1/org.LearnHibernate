package org.aditya.hibernate;

import java.util.Date;

import org.aditya.javapractice.dto.Address;
import org.aditya.javapractice.dto.UserDetails;
import org.aditya.javapractice.dto.UserDetails1;
import org.aditya.javapractice.dto.UserDetails2;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class HibernateTest1 {

	public static void main(String[] args) {
		
		UserDetails2 user = new UserDetails2();
		user.setUserName("First User");
		
		/*UserDetails2 user2 = new UserDetails2();
		user1.setUserName("Second User");*/
		
		Address addr = new Address();
		addr.setStreet("Home Street Name");
		addr.setCity("Home City Name");
		addr.setPincode("Home Pin Code");
		user.setHomeAddress(addr);
		
		Address addr1 = new Address();
		addr1.setStreet("Street Name");
		addr1.setCity("City Name");
		addr1.setPincode("Pin Code");
		user.setOffficeAddress(addr1);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		//session.save(user1);
		session.getTransaction().commit();
		session.close();
		
	}

}
