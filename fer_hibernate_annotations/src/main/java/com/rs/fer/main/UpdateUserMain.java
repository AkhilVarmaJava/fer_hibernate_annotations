package com.rs.fer.main;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class UpdateUserMain {

	public static void main(String[] args) {
		
		// to get original object
		int userId = 1;

		FERService ferservice = new FERServiceImpl();
		User user = ferservice.getUser(userId);
		
		if(user==null) {
			System.out.println("user not found");
			return;
		}
		
		//1.load the input 
		user.setFirstName("abc");
		user.setMiddleName("B");
		user.setLastName("rs");
		user.setEmail("admin@gmail.com");
		user.setUserName("Dev");
		user.setPassword("123");
		user.setMobile("98765432");
		
		Address address=user.getAddress();
		address.setLine1("Madhapur");
		address.setLine2("Hyd");
		address.setCity("Hyderbad");
		address.setState("TS");
		address.setPincode(500080);
		address.setCountry("India");
		
		//2.call the service
		
		boolean isUserUpdate=ferservice.updateUser(user);
		
		//3.print the status
		
		if(isUserUpdate) {
			System.out.println("Profile updated successfully..");
		}
		else {
			System.out.println("Profile update failed");
		}
		
	
	}

}
