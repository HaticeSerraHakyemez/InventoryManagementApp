package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Category;
import com.example.demo.repositories.CategoryRepository;

@RestController
public class CategoryController {
	
	@Autowired
  private CategoryRepository categoryRepo;
	
	 @GetMapping("/categories")
	  public List<Category> getAllCategorys(){
	    return categoryRepo.findAll();
	  } 
	  @PostMapping("/categories/newCategory")
	  public void addCategory(@RequestBody Category newCategory){
		  categoryRepo.save(newCategory);
	  }
	  
	  @DeleteMapping("/categories/delete")  
	  public boolean deleteCategory(@RequestParam String categoryName)  
	  {  
			  if(!categoryRepo.findById(categoryName).equals(Optional.empty())) {
				  categoryRepo.deleteById(categoryName);
				  return true;
			  }
		  return false;
	  }  

}