package com.rs.fer.main;

import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class GetExpensesMain {

	public static void main(String[] args) {
		// 1.load the input
		int userId = 1;

		// 2.call the service for business execution
		FERService ferservice = new FERServiceImpl();
		List<Expense> expenses = ferservice.getExpenses(userId);

		// 3.print the status
		if (expenses.isEmpty()) {
			System.out.println("Expense not Found...");
		} else {
			for(Expense expense :expenses) {

			System.out.println("Expense type :" + expense.getType());
			System.out.println("Date :" + expense.getDate());
			System.out.println("Price :" + expense.getPrice());
			System.out.println("no of items :" + expense.getNumofItems());
			System.out.println("Total :" + expense.getTotal());
			System.out.println("by whom :" + expense.getByWhom());
			
			System.out.println("______________________________ ");
			
		}

	}

}
}
