package org.aditya.hibernate;

import java.util.Date;
import java.util.List;

import org.aditya.javapractice.dto.UserDetails;
import org.aditya.javapractice.dto.UserDetails1;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class HibernateHQLVideo25 {
// Note no class is created for this in DTO
	public static void main(String[] args) {
	
		/*Do this and make change in the hibernate.cfg.xml to UPDATE from create
		for(int i =1; i<=10; i++){
			UserDetails user = new UserDetails();
			user.setUserName("User " +i);
		}*/
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		/*Now if we have to get a user ont just 1 based on the id. but every user in the user details table
		we write a query (HQL) after the begin transaction
		In SQL we use the table name to get the data but in HQL we use the JAVA Object name (pojo)
		 to get the data from the database like below.
		*/
		
		//Note there is no Select * in the HQL
		//Query query = session.createQuery("from UserDetails"); //Note we imported Hibernate QUERY and not JPA
		//List users = query.list();// This will give all the data in the USERDETAILS table.
		
		//Now if we want to get users with id > 5 in SQL we use the table column name and in HQL we use the
		//property name in the UserDetails  class which is userId
		
		Query query = session.createQuery("from UserDetails where userId > 5");
		List<UserDetails> users = (List<UserDetails>) query.list();

		session.getTransaction().commit();
		session.close();
		users.forEach(u -> System.out.println(u.getUserName())); //java 8 for each
		
		
		//********Initial difference b/w HQL and SQL*************
		//First difference is we use the class name instead of table name and property name instead if columnname
		//second diff is we dont use select *
		//3rd diff is instead of returning a record set hibernate returns a List of entity object
		
	}

}
