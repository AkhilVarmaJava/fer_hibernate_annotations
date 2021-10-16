package com.rs.fer.main;

import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class ResetPasswordMain {

	public static void main(String[] args) {
		// 1.load the input
		int userId=1;
		String currentPassword="abc";
		String newPassword="xyz";

		// 2.call the service for business execution
		FERService ferservice = new FERServiceImpl();
		boolean isReset = ferservice.resetPassword(newPassword,userId,currentPassword);

		// 3.print the status
		if (isReset) {
			System.out.println("Password updated successfully");
		} else {
			System.out.println("Password Update failed");
		}

	}

}
