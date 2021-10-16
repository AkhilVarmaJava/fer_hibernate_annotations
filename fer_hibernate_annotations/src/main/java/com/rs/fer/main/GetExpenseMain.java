package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class GetExpenseMain {

	public static void main(String[] args) {
		// 1.load the input
		int expenseId = 1;

		// 2.call the service for business execution
		FERService ferservice = new FERServiceImpl();
		Expense expense = ferservice.getExpense(expenseId);

		// 3.print the status
		if (expense == null) {
			System.out.println("Expense not Found...");
		} else {

			System.out.println("Expense type :" + expense.getType());
			System.out.println("Date :" + expense.getDate());
			System.out.println("Price :" + expense.getPrice());
			System.out.println("no of items :" + expense.getNumofItems());
			System.out.println("Total :" + expense.getTotal());
			System.out.println("by whom :" + expense.getByWhom());

		}

	}

}
