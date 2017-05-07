package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	public CustomerService customerService;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel){
		
		List<Customer> customers = customerService.getCustomers();
		
		theModel.addAttribute("customers", customers);
		
		return "list-customer";
	}
	
	@GetMapping("/showFormForAdd")
	public String showForm(Model theModel){
		
		Customer customer = new Customer();
		
		theModel.addAttribute("customer",customer);
		
		
		return "customer-form";
	}
	
	@PostMapping("/addCustomer")
	public String addCustomer(@ModelAttribute("customer") Customer theCustomer){
		
		customerService.addCustomer(theCustomer);
		
		return "redirect:/customer/list";
		
	}
	
	@GetMapping("/showUpdateForm")
	public String showUpdateForm(@ModelAttribute("id") int id,Model theModel){
		
		Customer singleCustomer = customerService.getCustomer(id);
				
		theModel.addAttribute("customer", singleCustomer);
		
		
		return "customer-form";
		
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@ModelAttribute("id") int id){
		
		customerService.deleteCustomer(id);
		
		return "redirect:/customer/list";
		
	}
}
