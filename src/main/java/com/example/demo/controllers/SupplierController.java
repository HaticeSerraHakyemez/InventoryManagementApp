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
import com.example.demo.models.Supplier;
import com.example.demo.repositories.CompanyRepository;
import com.example.demo.repositories.SupplierRepository;

@RestController
public class SupplierController {
	
	@Autowired
   private SupplierRepository supplierRepo;
	@Autowired
	private CompanyRepository companyRepo;
	
	 @GetMapping("/suppliers")
	  public List<Company> getAllSuppliers(){
	    return companyRepo.findAllSuppliers();
	  } 
	  
	  @GetMapping("/suppliers/find/{supplierId}")
	  public Optional<Company> getSupplierWithId(@PathVariable Integer supplierId){
	    return companyRepo.findById(supplierId);
	  } 
	  
	  @PostMapping("/suppliers/newSupplier")
	  public void addSupplier(@RequestBody Company newSupplier){
		  companyRepo.save(newSupplier);
	      supplierRepo.save(new Supplier(newSupplier.getId()));
	  }
	  
	  
	  @DeleteMapping("/suppliers/delete/{supplierId}")  
	  public boolean deleteSupplier(@PathVariable Integer supplierId)  
	  {  
			  if(!supplierRepo.findById(supplierId).equals(Optional.empty())) {
				  supplierRepo.deleteById(supplierId);
				  return true;
			  }
		  return false;
	  }  
}

