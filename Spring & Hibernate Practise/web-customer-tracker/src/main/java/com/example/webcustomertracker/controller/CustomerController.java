package com.example.webcustomertracker.controller;

import java.util.List;

import com.example.webcustomertracker.dao.CustomerDAO;
import com.example.webcustomertracker.entity.Customer;
import com.example.webcustomertracker.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/customer")
public class CustomerController {

	// need to inject the customer dao
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		// get customers from the dao
		List<Customer> theCustomers = customerService.getCustomers();
				
		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model){
		Customer customer = new Customer();

		model.addAttribute("customer",customer);

		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer){

		customerService.saveCustomer(customer);

		return "redirect:/customer/list";
	}

	@GetMapping("/showFormUpdate")
	public String showFormUpdate(@RequestParam("customerId") int id, Model model){

		Customer customer = customerService.getCustomer(id);

		model.addAttribute("customer",customer);

		return "customer-form";

	}

	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int id, Model model){

		customerService.deleteCustomer(id);

		return "redirect:/customer/list";

	}
	
}


