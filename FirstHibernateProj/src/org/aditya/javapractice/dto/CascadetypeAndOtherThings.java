package org.aditya.javapractice.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.OneToMany;

public class CascadetypeAndOtherThings {
//video 16
	
	/*Consider a manytoone relationship on a vehicle. Suppose if a vehicle dint have any user
	hibernate always throws an exception says hey this vehicle dont have a user. 
	to avoid this we can use an annotation called @NotFound just below the @manytoone annotation.
	This @NotFound(action=NotFoundAction.Ignore) has an action to ignore.*/ 
	
									//Cascading :
//	@OneToMany
//	private Collection<VehicleManyToOne> vehicle = new ArrayList<VehicleManyToOne>();
	/*consider in the use detailso Object we have a reference for the vehicle object as
	OneToMany. lets say both vehicles and users are Entities.So in the HibernateTest class
	we normally Save User object as well as Vehicle Object other wise we get an exception.
	
	Now lets say a user has 100 vehicles. Now we dont want to save every vehicle instead
	we tell hibernate to cascade.persist just like below 
	
	@OneToMany(cascade=CascadeType.PERSIST)
	private Collection<VehicleManyToOne> vehicle = new ArrayList<VehicleManyToOne>();
	
	This tells hibernate to automatically save the vehicle object instead of saving manually.
	but there is another change in the HibernateTest class. We need to use persist instead of save.
	
	before session.save(user);
	session.save(vehicle);
	session.save(vehicle1);... etc untill 100
	now after using cascade we can skip saving all the vehicles ad just save user
	session.persist(user);
	
	*/
	
}
