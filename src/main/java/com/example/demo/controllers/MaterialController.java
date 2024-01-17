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

import com.example.demo.models.Item;
import com.example.demo.models.Material;
import com.example.demo.repositories.ItemRepository;
import com.example.demo.repositories.MaterialRepository;

@RestController
public class MaterialController {
	
	@Autowired
  private MaterialRepository materialRepo;
	@Autowired
	private ItemRepository itemRepo;
	
	 @GetMapping("/materials")
	  public List<Item> getAllMaterials(){
	    return itemRepo.findAllMaterials();
	  } 
	  
	  @GetMapping("/materials/find/{materialId}")
	  public Optional<Item> getMaterialWithId(@PathVariable Integer materialId){
	    return itemRepo.findById(materialId);
	  } 
	  
	  @GetMapping("/materials/orders/{materialId}")
	  public String getMaterialOrders(@PathVariable Integer materialId){
		  Integer orderAmount=materialRepo.findMaterialOrders(materialId);
		  if(orderAmount==null) {
			  return "No purchase orders";
		  }
		  return "There are a total of "+orderAmount+" parcel of purchase orders for this material.";
	  } 
	  
	  @PostMapping("/materials/newMaterial")
	  public void addMaterial(@RequestBody Item newMaterial){
		itemRepo.save(newMaterial);
        materialRepo.save(new Material(newMaterial.getId()));
	  }
	  
	  @DeleteMapping("/materials/delete/{materialId}")  
	  public boolean deleteMaterial(@PathVariable Integer materialId)  
	  {  
			  if(!materialRepo.findById(materialId).equals(Optional.empty())) {
				  materialRepo.deleteById(materialId);
				  itemRepo.deleteById(materialId);
				  return true;
			  }
		  return false;
	  }  
}
