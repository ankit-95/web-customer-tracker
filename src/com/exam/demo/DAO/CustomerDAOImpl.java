package com.exam.demo.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.demo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	SessionFactory  factory;

	@Override
	public List<Customer> getCustomers() {
		// get the current hibernate session
				Session currentSession = factory.getCurrentSession();
						
				// create a query  ... sort by last name
				Query<Customer> theQuery = 
						currentSession.createQuery("from Customer order by id",
													Customer.class);
				
				// execute query and get result list
				List<Customer> customers = theQuery.getResultList();
						
				// return the results		
				return customers;
	}

	@Override
	public int addCust(Customer c) {
		
		Session session = factory.getCurrentSession();
		
		session.save(c);
		
		return c.getId();
	}

	@Override
	public void updateCust(Customer c) {
		// Update the Customer
		
		Session session = factory.getCurrentSession();
		session.update(c);
		
	}

	@Override
	public void deleteCust(int id) {
		// Delete Customer
		
		Session session = factory.getCurrentSession();
		
		Customer c = session.get(Customer.class, id);
		
		session.delete(c);
		
		
	}
	
	
	
	
}
