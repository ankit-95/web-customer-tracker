package com.exam.demo.DAO;

import java.util.List;

import com.exam.demo.entity.Customer;

public interface CustomerDAO {

	List<Customer> getCustomers();
	
	int addCust(Customer c);
	
	void updateCust(Customer c);
	
	void deleteCust(int id);
}
