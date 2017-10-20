package org.aditya.hibernate;

import java.util.Date;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;

import org.aditya.javapractice.dto.UserDetails;
import org.aditya.javapractice.dto.UserDetails1;
import org.aditya.javapractice.dto.UserDetailsCache32;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.cache.EhCache;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class HibernateCache32 {
	
	/*Cache Feature in hibernate : 
		
		2 ways of cacheling hibernate provides : 
			1. First Level Cache : This is by default provided by hibernate  using Session. 
				Meaning: If we use a session.get to get the data for eg : 
				UserDetailsCache32 user = (UserDetailsCache32) session.get(UserDetailsCache32.class,1);
				and if we use this quer for user 2 as well without any changes 
				UserDetailsCache32 user2 = (UserDetailsCache32) session.get(UserDetailsCache32.class,1);
				
					Hibernate inteligently makes only one select call to the database. And since the data
					is already present in the cache hibernate wont make a select call again. 
					
					Disadvantage : first level cacheing applies only between the session ie open and close session. 
					
				Now lets say if we change something after the first call ie and make a select query
				UserDetailsCache32 user = (UserDetailsCache32) session.get(UserDetailsCache32.class,1);
				user.setUserName("Updated User Name");
				UserDetailsCache32 user2 = (UserDetailsCache32) session.get(UserDetailsCache32.class,1);
				Even in this case since this is between on one session hibernate wont make another
				select query to the database. Since even if we change the property it knows what are the
				changes made and second time it looks inside the cache and wont make a dB call.
				
				But lets say if the first user is in one session and user2 is in another session then
				Hibernate will make 2 select calls to the DB to get the data. THIS PROBLEM IS ADDRESSED
				IN SECOND LEVEL CACHE
				
					
			
			2. Second level Cache :
				a. Accross different sessions in the application.
				b. Accross Different Applications ( Note All the apps should use hibernate). Its like different
					sessions in different apps. We can configure
				c. Accross Cluster. different apps deployed in diff servers and all are talking to the same DB
					 we can have a hibernate cache that supplies data accross all the applucations.
					 But however if an app is not using hibernate then that might be a problem and end up
					 dirtying the data like updating data in the db and dirty the cache for other apps. 
				
				To configure the 2nd cache : We use EhCache.class There are a lot of cache but we used ehcache.
				<property name="cache.use_second_level_cache">true</property>
				In hibernate.cfg.xml <property name="cache.provider_class">org.hibernate.cache.EhCacheProvider</property>
				
				Download latest ehcache from ehcache.org and add it to the class path using ehcache-core-2.7.9.jar
				After this, we need to configure he entities that needs 2nd level cache. Not all entities need this 
				2nd level cache. In this eg we used UserDetailsCache32.java class for 2nd level cache.
				
				The way we configure is this way : 
					
				@Entity 
				@Cacheable 
				@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
				public class UserDetailsCache32 { ie just below the entity we have an annotation call @Cacheble
				and another annotation to configure weather it is a read-write 2nd level cache or just read or 
				NonStrict read-write , transactional. Read Only is the basic and if we specify any this that 
				should be specific for that entity itself. 
				Suppose if we take Read-only : Hibernate just pulls up all the data, add the data to the cache
				and wont bother if the app modified it or not hibernate dont update but it only supplies data when
				we request it gets  it from the cache and not from database. 
				
				Read-Write : We will not only read but also write so hibernate keeps a track of what updates have
				happened and if there is an update it updates the cache automatically.
				
				Nonstrict readwrite in not strict we might read a data which is updated long back but Read_write 
				which is the above one is pretty strict it keeps track of everything
				
				Transactional : Its very strict of all. It keeps track of everything transaction to transaction.
				
				In this we do a read only since we are not writing anything to db. we are just making 2 select queries
				and expecting only one select query to the db since after first call hibernate will keep the data 
				in the cache and for the 2nd call we it gets data from the cache. 
				
	
	--> Apart from these there is also a query level cache in hibernate which is used at the query level.
	To configure go to hibernate.cfg.xml  there is another prop for querylevel cache just like second_level_cache
	sety it to true like below
	
	<property name="cache.use_query_cache">true</property>
	<property name="cache.provider_class">org.hibernate.cache.EhCacheProvider</property>
	
	now , Considering the below example here here below the query we need to set the query.setcacheble(true).
	and if we set it for one session and not the 2nd it will run the select query twice. But if we set it in
	both the sessions then it will run the select only once. BECAUSE setCacheble not only has the for to set it
	to true but it also tells hibernate to see if the select query is in th query cache and if it is available
	then do not run the query again.
	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from UserDetailsCache32 user where user.userId  = 1");
		query.setCacheable(true);
		List users = query2.list();
		
		session.getTransaction().commit();
		session.close();
		
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		
		Query query2 = session2.createQuery("from UserDetailsCache32 user where user.userId  = 1");
		query2.setCacheable(true);
		users = query2.list();
		
		session.getTransaction().commit();
		session.close();
	
	*/

	public static void main(String[] args) {
		
		/*UserDetailsCache32 user = new UserDetailsCache32();
		user.setUserName("First User");*/
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		UserDetailsCache32 user = (UserDetailsCache32) session.get(UserDetailsCache32.class,1);
		
		session.getTransaction().commit();
		session.close();

		
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		
		UserDetailsCache32 user2 = (UserDetailsCache32) session.get(UserDetailsCache32.class,1);
		
		session.getTransaction().commit();
		session.close();
		
	}

}
