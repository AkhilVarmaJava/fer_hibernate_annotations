package com.rs.fer.main;

import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class ExpenseReportMain {

	public static void main(String[] args) {
		// 1.load the input
		int userId = 1;
		String type="watch";
		String fromDate="01-10-2021";
		String toDate="12-11-2021";

		// 2.call the service for business execution
		FERService ferservice = new FERServiceImpl();
		List<Expense> expenseReport = ferservice.getExpenseReport(userId,type,fromDate,toDate);

		// 3.print the status
		if (expenseReport.isEmpty()) {
			System.out.println("Expense not Found...");
		} else {
			for(Expense expense :expenseReport) {

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
