package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class AddExpenseMain {

	public static void main(String[] args) {
		// 1.load the input
		Expense expense = new Expense();
		expense.setType("Watch");
		expense.setDate("11-10-2021");
		expense.setPrice(100);
		expense.setNumofItems(4);
		expense.setTotal(300);
		expense.setByWhom("Admin");
		expense.setUserId(1);

		// 2.call the service for business execution
		FERService ferservice = new FERServiceImpl();
		boolean isAddExpense = ferservice.addExpense(expense);

		// 3.print the status
		if (isAddExpense) {
			System.out.println("Expenses added successfully...");
		} else {
			System.out.println("Expense add is failed..");
		}
		System.out.println("Git commit check..");
	}

}
