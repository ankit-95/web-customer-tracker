package com.exam.demo.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.demo.DAO.CustomerDAO;
import com.exam.demo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDAO customerdao;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
	
		return customerdao.getCustomers();
	}

	@Override
	@Transactional
	public int addCust(Customer c) {
		// TODO Auto-generated method stub
		return customerdao.addCust(c);
	}

	@Override
	@Transactional
	public void updateCust(Customer c) {
		// TODO Auto-generated method stub
		customerdao.updateCust(c);
		
	}

	@Override
	@Transactional
	public void deleteCust(int id) {
		// TODO Auto-generated method stub
		
		customerdao.deleteCust(id);
		
	}

}
