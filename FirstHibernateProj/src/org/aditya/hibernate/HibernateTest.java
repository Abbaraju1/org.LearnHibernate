package org.aditya.hibernate;

import java.util.Date;

import org.aditya.javapractice.dto.UserDetails;
import org.aditya.javapractice.dto.UserDetails1;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class HibernateTest {

	public static void main(String[] args) {
		
		UserDetails1 user = new UserDetails1();
		user.setUserId(1);
		user.setUserName("First User");
		user.setAddress("First User's Address");
		user.setJoinedDate(new Date());
		user.setDescription("First User's Description");
		
		//Session factory is only created once.
		//building a session factory to let hibernate know to take the hibernate.cfg.xml file
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		//openning a new sessions from session factory
		Session session = sessionFactory.openSession();
		//we need to begin the transaction and in this transaction we can save as
		//many objects as we can
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		/*To fetch the USER object from the database we need to close the session
		and open a new session. Normally if we do exception handling close
		session should be in finally , catch will have transaction.rollback
		and the above code will be in try block.*/
		session.close();
		
		//to fetch we need to make user null.
		user = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = (UserDetails1) session.get(UserDetails1.class, 1); // 1 is specified because it is
		//the primary key of the userDetails object.
		
		System.out.println("User Name retrieved is : " + user.getUserName());
		
	}

}
