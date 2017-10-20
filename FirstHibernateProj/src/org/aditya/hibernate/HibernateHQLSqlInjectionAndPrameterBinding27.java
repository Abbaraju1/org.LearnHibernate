package org.aditya.hibernate;

import java.lang.reflect.Parameter;
import java.util.Date;
import java.util.List;

import org.aditya.javapractice.dto.UserDetails;
import org.aditya.javapractice.dto.UserDetails1;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class HibernateHQLSqlInjectionAndPrameterBinding27 {
// Note no class is created for this in DTO
	public static void main(String[] args) {
	
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from UserDetails");
		
		//******Sql InJection :
		/*Now lets say in the above query we are passing a param which users sends for eq :
		String minUserId = 5; and the query will be 
		Query query = session.createQuery("from UserDetails where userId > " +minUserId);
		By allowing the user params in the query can cause a very big security problem which is SQL injection.
		Meaning if we allow the input parameters from the USER input in Query a hacker can change the value
		of minUserId = "5 or 1=1"; where 1 will always be equal to 1 so the UserDetails all the data will 
		be displayed which is very risky. A hacked can also delete complete data by modifying the user 
		input string which is minUserId.*/
		/*
		We can solve SQL injection by using a parameter in the Query like :
		Query query = session.createQuery("from UserDetails where userId > ?"); where ? is a place holder
		for where the param needs to go. the way we supply data to the query is by using query.setString or int or etc
		ie. query.setInteger(0, Integer.parseInt(minUserId)); where 0 is the position indicator.
		We canhave multiple param where the value in 0 will tell the position of the Parameter
		For Eg : session.createQuery("from UserDetails where userId > ? and userName =?" );
		So we set this by query.setInteger(0, Integer.parseInt(minUserId));
		and 2nd ? by query.setString(1, username); 
		
		Without having the worry of the position we can also do this using namedparameter ie by replacing ? with ":name" ie
		session.createQuery("from UserDetails where userId > :userid and userName = :userName" );
		query.setinteger(userid , Integer.parseInt(minUserId));
		query.setString(userName, username); 
		
		So these are 2 ways to do param substitution. 1. by positon ie ? 2. By name ie :userid etc
		
		*/
		
		
		List<UserDetails> users = (List<UserDetails>) query.list();
		
		session.getTransaction().commit();
		session.close();
		
		}
}
