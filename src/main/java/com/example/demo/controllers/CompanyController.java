package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Company;
import com.example.demo.repositories.CompanyRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@RestController
public class CompanyController {
	
	@Autowired
  private CompanyRepository companyRepo;
	
	 @GetMapping("/companies")
	  public String getAllCompanies() throws JsonProcessingException{
		 XmlMapper xmlMapper = new XmlMapper();
		 String xml = xmlMapper.writeValueAsString(companyRepo.findAll());
	    return xml;
	  } 
	 
	 @GetMapping("/companies/find/{companyId}")
	  public Optional<Company> getCompanyWithId(@PathVariable Integer companyId) {
	    return companyRepo.findById(companyId);
	  } 
	 
	 @GetMapping("/companies/findByCountry")
	  public List<Company> getCompanyWithCountry(@RequestParam String country){
	    return companyRepo.findByCountry(country);
	  } 
	 
	  @DeleteMapping("/companies/delete/{companyId}")  
	  public boolean deleteCompany(@PathVariable Integer companyId)  
	  {  
			  if(!companyRepo.findById(companyId).equals(Optional.empty())) {
				  companyRepo.deleteById(companyId);
				  return true;
			  }
		  return false;
	  }  
}
