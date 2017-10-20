package org.aditya.hibernate;

import java.util.Date;

import javax.persistence.Table;

import org.aditya.javapractice.dto.FourWheelerVehicle;
import org.aditya.javapractice.dto.TwoWheelerVehicle;
import org.aditya.javapractice.dto.UserDetails;
import org.aditya.javapractice.dto.UserDetails1;
import org.aditya.javapractice.dto.VehicleInheritance;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class HibernateInheritanceTest4 {

	public static void main(String[] args) {
		
		VehicleInheritance vehicle = new VehicleInheritance();
		vehicle.setVehicleName("vehicle");
		
		TwoWheelerVehicle twoWhlr = new TwoWheelerVehicle();
		twoWhlr.setVehicleName("BMW Bike");
		twoWhlr.setSteeringHandle("Bike Handle");
		
		FourWheelerVehicle fourWhlr = new FourWheelerVehicle();
		fourWhlr.setVehicleName("BMW Car");
		fourWhlr.setSteeringWheel("Car Handle");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(vehicle);
		session.save(twoWhlr);
		session.save(fourWhlr);
		
		/*So no matter if we save all the 3 entities in the above hibernate creates a single table
		for the the children of the parent and save it in one Table.class Suppose if a fourwheeler class
		is extended by another class then that is also added in the main table which is vehicle.
		
		Hibernate creates a Dtype (Discrminator type) field reference in the table which tells what class it is.
		This is the default way hibernate implements inheretance if we dont tell hibernate anything.
		*
		*/
		session.getTransaction().commit();
		session.close();
	}

}
