package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Item;
import com.example.demo.repositories.ItemRepository;

@RestController
public class ItemController {
	
	@Autowired
  private ItemRepository ItemRepo;
	
	 @GetMapping("/items")
	  public List<Item> getAllItems(){
	    return ItemRepo.findAll();
	  } 
	  
	  @GetMapping("/items/find/{itemId}")
	  public Optional<Item> getItemWithId(@PathVariable Integer itemId){
	    return ItemRepo.findById(itemId);
	  } 
	  
	  @DeleteMapping("/items/delete/{itemId}")  
	  public boolean deleteItem(@PathVariable Integer itemId)  
	  {  
			  if(!ItemRepo.findById(itemId).equals(Optional.empty())) {
				  ItemRepo.deleteById(itemId);
				  return true;
			  }
		  return false;
	  }  
	  
	  @PutMapping("/items/edit/{itemId}")
	  public void editItem(@PathVariable Integer itemId, @RequestParam String name){
		ItemRepo.findById(itemId).get().setName(name);
        ItemRepo.save(ItemRepo.findById(itemId).get());
	  }
	  
	  
}