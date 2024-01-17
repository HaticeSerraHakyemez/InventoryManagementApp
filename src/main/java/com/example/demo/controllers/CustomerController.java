package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Company;
import com.example.demo.models.Customer;
import com.example.demo.repositories.CompanyRepository;
import com.example.demo.repositories.CustomerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class CustomerController {
	
	@Autowired
    private CustomerRepository customerRepo;
	@Autowired
	private CompanyRepository companyRepo;
	
	 @GetMapping("/customers")
	  public List<Company> getAllcustomers() throws JsonProcessingException{
	    return companyRepo.findAllCustomers();
	  } 
	  
	  @GetMapping("/customers/find/{customerId}")
	  public Optional<Company> getcustomerWithId(@PathVariable Integer customerId){
	    return companyRepo.findById(customerId);
	  } 
	  
	  @PostMapping("/customers/newCustomer")
	  public void addcustomer(@RequestBody Company newcustomer){
		companyRepo.save(newcustomer);
        customerRepo.save(new Customer(newcustomer.getId()));
	  }
	  
	  @DeleteMapping("/customers/delete/{customerId}")  
	  public boolean deletecustomer(@PathVariable Integer customerId)  
	  {  
			  if(!customerRepo.findById(customerId).equals(Optional.empty())) {
				  customerRepo.deleteById(customerId);
				  companyRepo.deleteById(customerId);
				  return true;
			  }
		  return false;
	  }  
}