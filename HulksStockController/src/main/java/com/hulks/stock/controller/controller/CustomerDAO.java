package com.hulks.stock.controller.controller;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hulks.stock.controller.model.Customer;
import com.hulks.stock.controller.serviceInterfaces.ICustomerService;

/**
 * @author afvergani
 */
@Controller
@RequestMapping
public class CustomerDAO {
	
	@Autowired
	private ICustomerService service;
	private static Logger logger = Logger.getLogger(CustomerDAO.class);
	
	/**
	 * @param model
	 * @return redirect to listCustomers
	 */
	@GetMapping("/listCustomers")
	public String listCustomers(Model model) {
		List<Customer> customers = service.list();
		model.addAttribute("customers", customers);
		logger.info("Listing all Customers");
		logger.debug("Customers: " + customers.toString()
		);
		return "redirect:/listCustomers";
	}
	
	/**
	 * @param model
	 * @return formNewCustomer
	 */
	@GetMapping("/newCustomer")
	public String newCustomer(Model model) {
		model.addAttribute("customer", new Customer());
		logger.info("newCustomer requested");
		return "formNewCustomer";
		
	}
	
	
	/**
	 * @param newCustomer
	 * @param model
	 * @return redirect to listUser
	 */
	@PostMapping("/saveCustomer")
	public String save(@Validated Customer newCustomer, Model model) {
		service.add(newCustomer);
		logger.info("Adding new Customer");
		logger.debug("Customer parameters: " + newCustomer.toString());
		return "redirect:/listUser";
	}
	
	/**
	 * @param id
	 * @param model
	 * @return formNewCustomer
	 */
	@GetMapping("/editCustomer/{id}")
	public String updateCustomer(@PathVariable int id, Model model) {
		Optional<Customer> customer = service.listbyId(id);
		model.addAttribute("customer", customer);
		logger.info("Update Customer, customer ID: "+ id);
		logger.debug("Actual Customer parameters: " + customer.toString());
		return "formNewCustomer";
		
	}
	
	/** 
	 * @param id
	 * @param model
	 * @return redirect to listCustomers
	 */
	@GetMapping("/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable int id, Model model) {
		service.delete(id);
		logger.info("Customer deleted, customer ID: "+ id);
		return "redirect:/listCustomers";
	}

}
