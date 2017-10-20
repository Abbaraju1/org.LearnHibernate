package org.aditya.hibernate;

import java.lang.reflect.Method;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import org.aditya.javapractice.dto.Address;
import org.aditya.javapractice.dto.UserDetails;
import org.aditya.javapractice.dto.UserDetails2;
import org.aditya.javapractice.dto.UserDetailsCollections;
import org.aditya.javapractice.dto.UserDetailsOneToMany;
import org.aditya.javapractice.dto.UserDetailsOneToOneMapping;
import org.aditya.javapractice.dto.VehicleManyToOne;
import org.aditya.javapractice.dto.VehicleOneToOneMapping;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.omg.PortableServer.POAManagerPackage.State;

import javassist.compiler.ast.Variable;

public class HibernateTransientAndPersistanceObjects {
//Very Important video //video 22
	public static void main(String[] args) {
/*		//NOTE : For this class we didnot create any class in DTP package and we used existing
		
//		Transient Object : So after creating the UserDetails object and if we comment out session.save line
//		we are not saving the object. So hibernate doesnt keep a track of the record which is a transient 
//		Object
		
		UserDetails user = new UserDetails(); 
		user.setUserName("First User");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
//		Persistant Object : So after creating the user and if we use session.save to save the user then
//		hibernate will keep a track of the user Object which is called a persistant Object. 
//		So before we save if we change the object name it is changed and inserted in the Database.  
//		
//		Now lets take the other way.. we will save and after the if we  do user.setUserName("Updated User")
//		then hibernate will automatically call the update quert after the save to update the Object. 
//		
//		Now, lets update the user twice after save ie //user.setUserName("Updated User"); , 
//		//user.setUserName("Updated User Again");. Now hibernate wont call the insert query twice but it
//		intelligently calls the update query only once for the last changed update on the user object. Since
//		Hibernate keeps track of the object which is called Persistance Object
		
		
		//user.setUserName("Updated User");
		session.save(user); 
		//user.setUserName("Updated User");
		//user.setUserName("Updated User Again");
		
		session.getTransaction().commit();
		session.close();
		
		user.setUserName("Detached User");
//		Detached Object : Once we do a session.close. Now the persistance object becasue detached object
//		which means hibernate will no longer keep a track of the Object and any changes made wont be 
//		reflected in the database.
//		Now if we do a user.setUserName("Detached User"); this update wont go to the database. Since hibernate
//		wont keep a track of the object and this is no more hibernates resposibility to track this object
		*/ //Uncomment This for Video 22
		
//***************** Check Notes For more and on video 22 ******************//
		//Uncomment for Video 24
		//Now lets see if we can make make an Object from detached to Persistant
		
		//Make hibernate.cfg.xml to update to get data from Db.
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		UserDetails user = (UserDetails) session.get(UserDetails.class, 1);
		session.getTransaction().commit();
		session.close();
		
//		Lets consider We we get the data and pass it to the user in the UI and wait for the user to make/ dont
//		make changes and submit to update the details. Now we should have to keep the session open untill the
//		user gives the inpur. He might takes 1 min or 5 mins. Its waste to keep the session open. So what we
//		do is detach the object and make it to a DETACHED STATE.
//		
//		Now if the user makes the change lets say he updated the user name  like before coming from UI
		user.setUserName("UPDATED USER NAME AFTER THE SESSION CLOSED");
//		Then we have to make changes to the detached object and make it PERSISTANT object. So we do it by
//		openning the session again and calling the UPDATE Method which make a detached object persistant.
//		
//		Now lets say if user didnot make any changes like above for the username and still we want to make 
//		the detached object to a persistant object so we can either call the same update method  or we can
//		user a Hibernate annotation entity on the userdetails object just before @Entity anotation which is
//		a Jpa annotation like this
//		/*@Entity
//		@org.hibernate.annotations.Entity(selectBeforeUpdate=true)
//		public class UserDetails {*/
//		Which tells hibernate to make another select query and checks if there is any changes then it
//		calls the update method and updates DB.or it wont call the update query
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		session.close();
		
		
	}
}
