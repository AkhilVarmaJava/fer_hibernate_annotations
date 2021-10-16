package com.rs.fer.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.util.HibernateUtil;

public class FERServiceImpl implements FERService {

	@Override
	public boolean registration(User user) {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(user);

		transaction.commit();
		
		session.close();

		return true;

	}

	@Override
	public boolean login(String username, String password) {

		boolean isValid = false;

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();

		Criteria criteria = session.createCriteria(User.class);

		criteria.add(Restrictions.eq("userName", username));
		criteria.add(Restrictions.eq("password", password));

		List<User> users = criteria.list();

		isValid = (users != null && !users.isEmpty());

		return isValid;

	}

	@Override
	public boolean addExpense(Expense expense) {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(expense);

		transaction.commit();
		session.close();

		return true;

	}

	@Override
	public boolean editExpense(Expense expense) {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		session.update(expense);

		transaction.commit();
		session.close();

		return true;

	}

	@Override
	public boolean deleteExpense(int expenseId) {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Expense expense = new Expense();
		expense.setId(expenseId);
		session.delete(expense);

		transaction.commit();
		session.close();

		return true;

	}

	@Override
	public boolean resetPassword(String newPassword, int userId, String currentPassword) {
		boolean isReset = false;

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();

		Query query = session.createQuery("update User u set u.password=? where u.id=? and u.password=?");
		query.setParameter(0, newPassword);
		query.setParameter(1, userId);
		query.setParameter(2, currentPassword);

		int numOfRecEffected = query.executeUpdate();

		System.out.println("Numer of records effected " + numOfRecEffected);
		isReset = numOfRecEffected > 0;
		
		session.close();

		return isReset;
	}

	@Override
	public Expense getExpense(int expenseId) {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();

		Expense expense = (Expense) session.get(Expense.class, expenseId);

		return expense;
	}

	@Override
	public List<Expense> getExpenses(int userId) {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();

		Criteria criteria = session.createCriteria(Expense.class);
		criteria.add(Restrictions.eq("userId", userId));

		List<Expense> expenses = criteria.list();

		return expenses;

	}

	@Override
	public List<Expense> getExpenseReport(int userId, String type, String fromDate, String toDate) {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();

		Criteria criteria = session.createCriteria(Expense.class);
		criteria.add(Restrictions.eq("userId", userId));
		criteria.add(Restrictions.eq("type", type));
		criteria.add(Restrictions.between("date", fromDate, toDate));

		List<Expense> expenseReport = criteria.list();

		return expenseReport;

	}

	/*
	 * @Override public User getUser(int userId) { User user=new User(); Session
	 * session=null; try {
	 * 
	 * SessionFactory factory = HibernateUtil.getSessionFactory(); session =
	 * factory.openSession();
	 * 
	 * user = (User) session.get(User.class, userId); if (user.getAddress() == null)
	 * { user.setAddress(new Address()); } }finally { session.close(); }
	 * 
	 * return user; }
	 */
	@Override
	public User getUser(int userId) {
		User user = new User();

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();

		user = (User) session.get(User.class, userId);
		if (user.getAddress() == null) {
			user.setAddress(new Address());
		}

		session.close();

		return user;
	}

	@Override
	public boolean updateUser(User user) {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		session.saveOrUpdate(user);

		transaction.commit();
		session.close();

		return true;
	}

}
