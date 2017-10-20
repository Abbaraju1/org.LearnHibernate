package org.aditya.hibernate;

import java.util.Date;
import java.util.List;

import org.aditya.javapractice.dto.UserDetails;
import org.aditya.javapractice.dto.UserDetails1;
import org.aditya.javapractice.dto.UserDetailsCriteriaApi29;
import org.aditya.javapractice.dto.UserDetailsNamedQueries28;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class HibernateHQLCriteriaApi2930 {
// Note no class is created for this in DTO
	public static void main(String[] args) {
	
		/*//Do this and make change in the hibernate.cfg.xml to UPDATE from create
		for(int i =1; i<=10; i++){
			UserDetailsCriteriaApi29 user = new UserDetailsCriteriaApi29();
			user.setUserName("User " +i);
		}*/
		
	/*	Video 2930
	 * SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
//		So there are 3 ways to get data : 
//		
//		First : Simple and less control : session.get(UserDetails.class, 1);
//		Second : Using HQL NAmed Queries 
//		3rd : Criteria Api
//		
//		There are Some problems using 2nd ie HQL : So even the HQL becomes like a SQL since there is from , where 
//		and if we have to write a long query it takes like 10-15 lines and If we have to change the query we should
//		go through everything which is a pain so we will use 3rd way which is CriteriaAPi. Instead of using
//		Query query = session.getNamedQuery("UserDetails.byName"); we will use CriteriaApi
		

		Criteria criteria = session.createCriteria(UserDetailsCriteriaApi29.class);//So we are saying all the  conditions
		//we apply below apply for UserDetailsNamedQueries28.class and knows what table to specify the clause 
		criteria.add(Restrictions.eq("userName", "User 10")); // Here are are specifying the restrictions for eg :
		//If we want a username with name as "User 10" which is a restriction. So we specify this way. if we want all 
		//the records we can skip the restrictions line . ( Note : .eq is a equals restriction and there  are lot
		//like greater than , less than etc )
		
		List<UserDetailsCriteriaApi29> users = (List<UserDetailsCriteriaApi29>) criteria.list(); //Instead of 
		//query.List we use criteria.List
		
		//One cool thing about criteria is we can add mutliple restrictions in the same criteria object w/o taking it
		//everywhere for eg: 
		criteria.add(Restrictions.eq("userName", "User 10"))
				.add(Restrictions.gt("userId", 5));  // .gt treaterThan , .ge greaterthanEqualto, 
		//for Like  we need to add "%User10"which will pull up all the usernames with User 10
		
		//Another eg :
		criteria.add(Restrictions.like("userName", "%User 1%"))
		.		add(Restrictions.between("userId", 5  , 50));
		//So this .add is doing a conjunction operation ie And clause so it is checcking both the conditions and returns result.
		//If we have to do a OR clause then we can do it this way.
		
		criteria.add(Restrictions.or(Restrictions.between("userId", 0 , 3), Restrictions.between("userId", 7, 10)));
		//For the above query either query work so the result will be the records 1,2,3,7,8,9,10 ( 0 is not there in DB)
		
		
		
		session.getTransaction().commit();
		session.close();
		users.forEach(u -> System.out.println(u.getUserName())); //java 8 for each
	 	*/		
		
/*	 
 * Video 31: Projections and QueryBy Example
 * 
//		Projections : uses of projection is to implement aggregation or grouping fuctions we use this
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		//One way of projections is to get only that field and not the entire Object. 
		
//		Criteria criteria = session.createCriteria(UserDetailsCriteriaApi29.class)
//		.setProjection(Projections.property("UserId"));
		
		//2nd way is Now,lets say if we want the highest user id in table then in sql or hql we 
		//write a query select max userid; But in projection it is 
		
//		Criteria criteria = session.createCriteria(UserDetailsCriteriaApi29.class)
//									.setProjection(Projections.max("UserId"));
		
		// to order the user id in decending order
		Criteria criteria = session.createCriteria(UserDetailsCriteriaApi29.class)
				.addOrder(Order.desc("UserId"));
		
		
		List<UserDetailsCriteriaApi29> users = (List<UserDetailsCriteriaApi29>) criteria.list();
		session.getTransaction().commit();
		session.close();
		session.getTransaction().commit();
		session.close();
		users.forEach(u -> System.out.println(u.getUserName())); //java 8 for each
		*/
		
//		Video 31: Part 2 : Query By Example : 
//			
//		Query By example : So if we have to query a large query and we know most of the inputs then
//		we dont need to do the add for all the felds which is a pain instead we can create a example
//		on the object and pass it. 
//		
//		The true value of this will be known if we have a lot of member variables. but for our exampke
//		we  only have 2 fields and i dont want to make it complex.
		
			
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		UserDetailsCriteriaApi29 exampleUser = new UserDetailsCriteriaApi29();
		exampleUser.setUserId(5);
		exampleUser.setUserName("User 5");
		
		//Now we create a example which hibernate can use.
		Example example = Example.create(exampleUser); // This will tell hibernate i am intrested in creating
		//an example out of this object so it pulls up all the object that looks like the one we pass ie exampleUser.
		
		Criteria criteria = session.createCriteria(UserDetailsCriteriaApi29.class)
									.add(example);
		//Now it will return User 5. Another imp thing about example is hibernate ignores if there is any
		//property with null or if there is any property with primary key.
		//So in the above if we comment out exampleUser.setUserName("User 5"); then hibernate will return all 
		//users in the database since it is a primary key Example will IGNORE it. now if we do the other way
		// ie comment out exampleUser.setUserId(5); and uncomment username then it returns only User 5 matching
		// in the database
		
		
//		We can also skip a property in the example. Suppose if we have 5 properties and we dont want
//		one property in the result list then we can skip that using exclude like below :  and we 
		// can do as many as exclude properties as we need
//			Example example = Example.create(exampleUser).excludeProperty("userName");
		
//		We can use a like in example. Suppose if we want all users whose same starts with User 1 then we use enableLike() :
//		UserDetailsCriteriaApi29 exampleUser = new UserDetailsCriteriaApi29();
//		exampleUser.setUserName("User 1%");
//		Example example = Example.create(exampleUser).enableLike();
//		Criteria criteria = session.createCriteria(UserDetailsCriteriaApi29.class)
//									.add(example);
 		
		List<UserDetailsCriteriaApi29> users = (List<UserDetailsCriteriaApi29>) criteria.list();
		session.getTransaction().commit();
		session.close();
		session.getTransaction().commit();
		session.close();
		users.forEach(u -> System.out.println(u.getUserName())); //java 8 for each
		
		
		
	}

}
