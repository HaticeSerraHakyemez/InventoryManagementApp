package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Supply;
import com.example.demo.repositories.SupplyRepository;

@RestController
public class SupplyController {
	
	@Autowired
  private SupplyRepository supplyRepo;
	
	  @GetMapping("/supplies")
	  public List<Supply> getAllSupplies(){
	    return supplyRepo.findAll();
	  } 
	  
	  @GetMapping("/supplies/findByMaterial")
	  public List<Supply> getSupplyWithMaterial(@RequestParam Integer material){
	    return supplyRepo.findByMaterial(material);
	  } 
	  @GetMapping("/supplies/findByCompany")
	  public List<Supply> getSupplyWithCompany(@RequestParam Integer company){
		  return supplyRepo.findByCompany(company);
	  } 
	  
	  @PostMapping("/supplies/newSupply")
	  public void addSupply(@RequestBody Supply newSupply){
        supplyRepo.save(newSupply);
	  }
	  
	  @DeleteMapping("/supplies/delete/{supplyId}")  
	  public boolean deleteSupply(@PathVariable Integer supplyId)  
	  {  
			  if(!supplyRepo.findById(supplyId).equals(Optional.empty())) {
				  supplyRepo.deleteById(supplyId);
				  return true;
			  }
		  return false;
	  }  
	  
	  @PutMapping("/supplies/edit/{supplyId}")
	  public void editSupply(@PathVariable Integer supplyId, @RequestParam Double price){
		supplyRepo.findById(supplyId).get().setPrice(price);
        supplyRepo.save(supplyRepo.findById(supplyId).get());
	  }
	  
	  
}
