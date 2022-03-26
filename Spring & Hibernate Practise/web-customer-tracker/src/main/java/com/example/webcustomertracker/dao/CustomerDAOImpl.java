package com.example.webcustomertracker.dao;

import com.example.webcustomertracker.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Customer> getCustomers() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query
		Query<Customer> theQuery =
				currentSession.createQuery("from Customer order by id",
						Customer.class);
		
		// execute query and get result list

		// return the results		
		return theQuery.getResultList();
	}

	@Override
	public void saveCustomer(Customer customer) {

		Session session = sessionFactory.getCurrentSession();

		session.saveOrUpdate(customer);

	}

	@Override
	public Customer getCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();

		Customer customer = session.get(Customer.class,id);

		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class,id);
		session.delete(customer);
	}

}






