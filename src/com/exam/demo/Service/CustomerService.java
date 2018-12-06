package com.exam.demo.Service;

import java.util.List;

import com.exam.demo.entity.Customer;

public interface CustomerService {
	
	List<Customer> getCustomers();
	
	int addCust(Customer c);
	
	void updateCust(Customer c);	
	
	void deleteCust(int id);
}
