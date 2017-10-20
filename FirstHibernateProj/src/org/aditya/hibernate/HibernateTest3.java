package org.aditya.hibernate;

import javax.persistence.ElementCollection;
import javax.persistence.FetchType;

import org.aditya.javapractice.dto.Address;
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

public class HibernateTest3 {

	public static void main(String[] args) {
		
		//UserDetailsOneToOneMapping user = new UserDetailsOneToOneMapping();
		UserDetailsOneToMany user = new UserDetailsOneToMany(); 
		user.setUserName("First User");
		
		//VehicleOneToOneMapping vehicle = new VehicleOneToOneMapping();
		VehicleManyToOne vehicle = new VehicleManyToOne();
		vehicle.setVehicleName("CAR");
		
		//user.setVehicle(vehicle); used for onetoonemapping
		
		VehicleManyToOne vehicle2 = new VehicleManyToOne();
		vehicle2.setVehicleName("BMW");
		
		user.getVehicle().add(vehicle);
		user.getVehicle().add(vehicle2);
		
		//Bidirectional relationship
		vehicle.setUser(user);
		vehicle2.setUser(user);
		
		// for a many to many
		//vehicle.getUserList().add(user);
		//vehicle2.getUserList().add(user);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(user);
		session.save(vehicle);
		session.save(vehicle2); // So what hibernate does is it takes the user details primary key and vehicle
		//details primary key and creates a new table called user_details_vehicle which has 2 columns 
		//user_details_userid , vehicle_vehicleId which will have 2 rows  1 mapped to 2 and 1 mapped to 3
		// which is 1 user and 2 vehicles
 		session.getTransaction().commit();
 		
		session.close();
		
	}
}
