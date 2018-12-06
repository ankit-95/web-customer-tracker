package com.exam.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.exam.demo.DAO.CustomerDAO;
import com.exam.demo.Service.CustomerService;
import com.exam.demo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class HomeController {

	@Autowired
	CustomerService custServ;
	
	@RequestMapping("/list")
	public String listCustomers(Model m)
	{
		List<Customer> customers = custServ.getCustomers();
		m.addAttribute("data",customers);
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String addCust(Model m)
	{
		m.addAttribute("customer",new Customer());
		return "addCustForm";
	}
	
	@PostMapping("/showFormForAdd")
	public String addCustData(@ModelAttribute("customer") Customer customer, HttpServletRequest req)
		{
		int x = custServ.addCust(customer);
		if(x!=0)
		{
			req.setAttribute("msg","True");
		}
		else
		{
			req.setAttribute("msg","False");		
			}
		return "addCustForm";
		}
	
	@RequestMapping(value="/updateCust",method=RequestMethod.GET)
	public String updateCustomer(@RequestParam("id") int id,Model m)
	{
		Customer c = new Customer();
		c.setId(id);
		m.addAttribute("customer",c);
		return "update-Cust";
	}
	
	@RequestMapping(value="/updateCust",method=RequestMethod.POST)
	public String updatedCust(@ModelAttribute("customer") Customer c,HttpServletRequest req)
	{
		custServ.updateCust(c);
		req.setAttribute("msg", "True");
		return "update-Cust";
		
	}
	
	@RequestMapping(value="/deleteCust",method=RequestMethod.GET)
	public String deleteCustomer(@RequestParam("id") int id,Model m)
	{
		custServ.deleteCust(id);
		return "redirect:/customer/list";
	}
}
