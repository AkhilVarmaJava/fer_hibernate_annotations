package com.rs.fer.relationship.main;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;

public class GetUserMain {

	public static void main(String[] args) {
		System.out.println("Maven + Hibernate + MySQL");

		// 1.load the configuration
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		// 2.Build the session factory
		SessionFactory factory = configuration.buildSessionFactory();

		// 3.open the session
		Session session = factory.openSession();

		// 5.Do the actual call
		User user = (User) session.get(User.class, 5);
		System.out.println("User object created..");

		System.out.println(user.getUserName());

		if (user.getAddress() != null) {
			System.out.println(user.getAddress().getCountry());
		}

		Set<Expense> expenses = user.getExpenses();
		System.out.println("Expense object created..");

		Iterator<Expense> iterator = expenses.iterator();
		Expense expense = null;
		while (iterator.hasNext()) {

			expense = iterator.next();
			System.out.println(expense.getType());

		}
		
		
		//delete
		Transaction transaction=session.beginTransaction();
		session.delete(user);
		transaction.commit();

		// 7.close the session
		session.close();

	}

}
