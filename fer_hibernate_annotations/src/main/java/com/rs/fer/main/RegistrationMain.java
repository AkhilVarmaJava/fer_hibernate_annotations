package com.rs.fer.main;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class RegistrationMain {

	public static void main(String[] args) {
		// 1.load the input
		User user = new User();
		user.setFirstName("Devansh");
		user.setMiddleName("B");
		user.setLastName("Kondru");
		user.setEmail("teja@gmail.com");
		user.setUserName("teja");
		user.setPassword("abc");
		user.setMobile("123456789");

		// 2.call the service for business execution
		FERService ferservice = new FERServiceImpl();
		boolean isRegister = ferservice.registration(user);

		// 3.print the status
		if (isRegister) {
			System.out.println("User Registration is successful...");
		} else {
			System.out.println("User Registration is failed..");
		}

	}

}
