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
import com.example.demo.models.Product;
import com.example.demo.repositories.ItemRepository;
import com.example.demo.repositories.ProductRepository;

@RestController
public class ProductController {
	
	@Autowired
  private ProductRepository productRepo;
	@Autowired
	private ItemRepository itemRepo;
	
	 @GetMapping("/products")
	  public List<Item> getAllProducts(){
	    return itemRepo.findAllProducts();
	  } 
	  
	  @GetMapping("/products/find/{productId}")
	  public Optional<Item> getProductWithId(@PathVariable Integer productId){
	    return itemRepo.findById(productId);
	  } 
	  @GetMapping("/products/orders/{productId}")
	  public String getMaterialOrders(@PathVariable Integer productId){
		  Integer orderAmount=productRepo.findProductOrders(productId);
		  if(orderAmount==null) {
			  return "No sale orders";
		  }
		  return "There are a total of "+orderAmount+" parcel of sale orders for this product.";
	  } 
	  @GetMapping("/products/needed/{productId}")
	  public String getMaterialNeed(@PathVariable Integer productId){
		  Integer orderAmount=productRepo.findProductOrders(productId);
		  Integer neededAmount=productRepo.findProductNeed(productId);
		  if(neededAmount==null) {
			  if(orderAmount==null) {
				  return "No orders.";
			  }
			  return "Not in stocks. Total of "+ orderAmount+" parcel of production is needed for this product.";
		  }
		  if(neededAmount<=0) {
			  return "No production needed.";
		  }
		  return "There are a total of "+neededAmount+" parcel of production is needed for this product.";
	  } 
	  
	  
	  @PostMapping("/products/newProduct")
	  public void addProduct(@RequestBody Item newProduct){
		  itemRepo.save(newProduct);
		  productRepo.save(new Product(newProduct.getId()));
	  }
	  
	  @DeleteMapping("/products/delete/{productId}")  
	  public boolean deleteProduct(@PathVariable Integer productId)  
	  {  
			  if(!productRepo.findById(productId).equals(Optional.empty())) {
				  productRepo.deleteById(productId);
				  return true;
			  }
		  return false;
	  }  
	  
}