package com.rs.fer.main;

import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class LoginMain {

	public static void main(String[] args) {
		// 1.load the input
		String username="teja";
		String password="abc";

		// 2.call the service for business execution
		FERService ferservice = new FERServiceImpl();
		boolean isValidUser = ferservice.login(username, password);

		// 3.print the status
		if (isValidUser) {
			System.out.println("Welcome to User :"+username);
		} else {
			System.out.println("Incorrect username/password.please try again later..");
		}

	}

}
