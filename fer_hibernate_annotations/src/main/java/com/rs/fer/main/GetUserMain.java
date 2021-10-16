package com.rs.fer.main;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class GetUserMain {

	public static void main(String[] args) {
		// 1.load the input
		int userId = 1;

		// 2.call the service for business execution
		FERService ferservice = new FERServiceImpl();
		User user = ferservice.getUser(userId);

		// 3.print the status
		if (user == null) {
			System.out.println("User not Found...");
		} else {
			
			//print user data

			System.out.println("First name: "+user.getFirstName());
			System.out.println("Middle name:" +user.getMiddleName());
			System.out.println("Last name: "+user.getLastName());
			System.out.println("___________________");
			
			System.out.println("Emial:" +user.getEmail());
			System.out.println("Mobile: "+user.getMobile());
			System.out.println("________________");
			
			//print address data
			Address address=user.getAddress();
			System.out.println("Line1 :" +address.getLine1());
			System.out.println("Line2: "+address.getLine2());
			System.out.println("City :"+address.getCity());
			System.out.println("State :" +address.getState());
			System.out.println("pincode :" +address.getPincode());
			System.out.println("Country: "+address.getCountry());
			System.out.println("_______________");

		}

	}

}
