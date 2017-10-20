package org.aditya.hibernate;

import java.util.Date;
import java.util.List;

import org.aditya.javapractice.dto.UserDetails;
import org.aditya.javapractice.dto.UserDetails1;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class HibernateHQLSelectAndPagination26 {
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
		
		/*Query query = session.createQuery("from UserDetails");
		
		// Pagination : Suppose userdetails table in db has 10000 records its not correct to pull all the data
		// so we can give "query.setFirstResult(5);" which will start from the offset 5th record skipping the 
		//first four. We can also give a limit by using "query.setMaxResults(4);" which will fetch 4 records
		// from the 5th row. which is called Pagination.
		
		query.setFirstResult(5);
		query.setMaxResults(4);
		
		List<UserDetails> users = (List<UserDetails>) query.list();*/ //uncomment for pagination**********
		
		
		
		
		/*//SELECT : Now if we want only the username its not correct to call the entire UserDetails Object
		//from the db so we can use a select with the property name from Object like this
		//session.createQuery("select userName from UserDetails"); which will query only for username
		//Anyway hibernate is bydefault lazy loading but if we need only username we can use this and now
		// the List<UserDetails> is no more List of Objects but it is List<Strings>
		
		Query query = session.createQuery("select userName from UserDetails"); // we can retrieve map by select new Map(userid,
		//userName ) from userDetails); here result contains a list of Maps. 
		// We can also request select userid,userName from UserDetails which gives list of lists with userid,username
		//we can also use all the aggregation funcions like max , sum etc ie select max(userId) from UserDetails
		query.setFirstResult(5);
		query.setMaxResults(4);
		
		List<String> userNames = (List<String>) query.list();

		session.getTransaction().commit();
		session.close();
		userNames.forEach(System.out::println); //java 8 for each
*/	//Uncomment for Select query***************
		
		
		
		}

}
