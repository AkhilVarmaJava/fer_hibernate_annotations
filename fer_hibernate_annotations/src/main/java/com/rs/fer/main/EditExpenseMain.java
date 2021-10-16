package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class EditExpenseMain {

	public static void main(String[] args) {
		// 1.load the input
		Expense expense=new Expense();
		expense.setType("chocolate");
		expense.setDate("11-10-2021");
		expense.setPrice(100);
		expense.setNumofItems(3);
		expense.setTotal(300);
		expense.setByWhom("Teja");
		expense.setUserId(1);
		
		expense.setId(1);
		

		// 2.call the service for business execution
		FERService ferservice = new FERServiceImpl();
		boolean isEditExpense = ferservice.editExpense(expense);

		// 3.print the status
		if (isEditExpense) {
			System.out.println("Expenses edited successfully...");
		} else {
			System.out.println("Expense edit is failed..");
		}

	}

}
