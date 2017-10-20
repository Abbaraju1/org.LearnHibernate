package org.aditya.hibernate;

import javax.persistence.ElementCollection;
import javax.persistence.FetchType;

import org.aditya.javapractice.dto.Address;
import org.aditya.javapractice.dto.UserDetails;
import org.aditya.javapractice.dto.UserDetails2;
import org.aditya.javapractice.dto.UserDetailsCollections;
import org.aditya.javapractice.dto.UserDetailsOneToMany;
import org.aditya.javapractice.dto.UserDetailsOneToOneMapping;
import org.aditya.javapractice.dto.VehicleManyToOne;
import org.aditya.javapractice.dto.VehicleOneToOneMapping;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import javassist.compiler.ast.Variable;

public class HibernateCRUD {

	public static void main(String[] args) {
	//Basic CRUD operations //Note: For this we didnot create any class in DTP package and we used existing
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		for(int i=1; i<=10; i++){
			UserDetails user = new UserDetails(); 
			user.setUserName("User" +i);
			session.save(user); // creates users
		}
		UserDetails user = (UserDetails) session.get(UserDetails.class, 6); // read user
		
		//session.delete(user); // delete user
		
		user.setUserName("Updated User");
		session.update(user); // update user // update hibernate.cfg.xml to "update" from "create "so that
		//it wont drop the table
		
 		session.getTransaction().commit();
 		
		session.close();
		
	}
}
