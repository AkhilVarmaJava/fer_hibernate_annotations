package com.rs.fer.main;

import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class DeleteExpenseMain {

	public static void main(String[] args) {
		// 1.load the input
		int expenseId=2;
		
		// 2.call the service for business execution
		FERService ferservice = new FERServiceImpl();
		boolean isDeleteExpense = ferservice.deleteExpense(expenseId);

		// 3.print the status
		if (isDeleteExpense) {
			System.out.println("Expenses deleted successfully...");
		} else {
			System.out.println("Expense delete is failed..");
		}

	}

}
