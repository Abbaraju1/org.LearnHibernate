package org.aditya.hibernate;

import javax.persistence.ElementCollection;
import javax.persistence.FetchType;

import org.aditya.javapractice.dto.Address;
import org.aditya.javapractice.dto.UserDetails2;
import org.aditya.javapractice.dto.UserDetailsCollections;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import javassist.compiler.ast.Variable;

public class HibernateTest2 {

	public static void main(String[] args) {
		
		UserDetailsCollections user = new UserDetailsCollections(); //Use UserDetailsLazyEagarLoding for lazy 
		//and eagar and proxy object
		user.setUserName("First User");
		
		Address addr = new Address();
		addr.setStreet("First Street");
		addr.setState("First Street");
		addr.setCity("First City");
		addr.setPincode("10001");
		
		Address addr1 = new Address();
		addr1.setStreet("Second Street");
		addr1.setState("Second Street");
		addr1.setCity("Second City");
		addr1.setPincode("20002");
		
		user.getListOfAddresses().add(addr);
		user.getListOfAddresses().add(addr1);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(user);
 		session.getTransaction().commit();
 		
		session.close();
		
		user = null;
		session = sessionFactory.openSession();
		user = (UserDetailsCollections) session.get(UserDetailsCollections.class, 1);
		/*So by default hibernate uses Lazy initialization which means it only initializes
		the first level member variables. 
		For example : If a user has 100 different addresses and we only have to get the
		user name from the user object which calling all the list of adddress which is the
		2nd level member Variable. So hibernate by defalt only loads the user object and 
		not call any address object related queries. once user uses user.getlistofaddress
		that is when hibernate will make another query to call the Address object.
		The way hibernate does is by using a PROXY CLASS which will have exact same methods
		as the original user class but it wont load the 2nd level member variables which
		is the list of addresses. Once user makes a req it immediately makes a query to the 
		DB and gets the data and then calls the original method
		*/
		/*to test this is a proxy class and not original we close the session and then call the 
		user.getListOfAddresses() we get a exception which is lazyInitializationExceptiom*/
		//session.close(); uncomment to test the exception 
		System.out.println(user.getListOfAddresses().size());
		//In order to not get the exception and load the data after the session is closed
		// we can make the fetch type as eagar @ElementCollection(fetch=FetchType.EAGER)
		//in the userdetailscollections.java class above the varible listofaddresses
		
	}

}
