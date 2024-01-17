package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Warehouse;
import com.example.demo.repositories.WarehouseRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@RestController
public class WarehouseController {
	
	@Autowired
  private WarehouseRepository warehouseRepo;
	
	 @GetMapping("/warehouses")
	  public String getAllWarehouses() throws JsonProcessingException{
		 XmlMapper xmlMapper = new XmlMapper();
		 String xml = xmlMapper.writeValueAsString(warehouseRepo.findAll());
	    return xml;
	  } 
	  
	  @GetMapping("/warehouses/find/{warehouseId}")
	  public Optional<Warehouse> getWarehouseWithId(@PathVariable Integer warehouseId){
	    return warehouseRepo.findById(warehouseId);
	  } 
	  
	  @PostMapping("/warehouses/newWarehouse")
	  public void addWarehouse(@RequestBody Warehouse newWarehouse){
        warehouseRepo.save(newWarehouse);
	  }
	  
	  @DeleteMapping("/warehouses/delete/{warehouseId}")  
	  public boolean deleteWarehouse(@PathVariable Integer warehouseId)  
	  {  
			  if(!warehouseRepo.findById(warehouseId).equals(Optional.empty())) {
				  warehouseRepo.deleteById(warehouseId);
				  return true;
			  }
		  return false;
	  }  
}