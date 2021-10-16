package com.rs.fer.relationship.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;

public class SaveUserMain {

	public static void main(String[] args) {
		System.out.println("Maven + Hibernate + MySQL");

		// 1.load the configuration
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		// 2.Build the session factory
		SessionFactory factory = configuration.buildSessionFactory();

		// 3.open the session
		Session session = factory.openSession();

		// 4.Begin the transaction
		Transaction transaction = session.beginTransaction();

		// 5.Do the actual call
		Address address = new Address();
		address.setCountry("India");

		Set<Expense> expenses = new HashSet<Expense>();

		Expense expense1 = new Expense();
		expense1.setType("Tea");

		Expense expense2 = new Expense();
		expense2.setType("Coffee");

		Expense expense3 = new Expense();
		expense3.setType("Chocolate");

		expenses.add(expense1);
		expenses.add(expense2);
		expenses.add(expense3);

		User user = new User();
		user.setUserName("Admin");

		user.setExpenses(expenses);

		user.setAddress(address);

		session.save(user);

		// 6.commit the transaction
		transaction.commit();

		// 7.close the session
		session.close();

	}

}
