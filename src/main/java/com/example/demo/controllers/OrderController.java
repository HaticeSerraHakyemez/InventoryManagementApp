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

import com.example.demo.models.Orders;
import com.example.demo.repositories.OrderRepository;

@RestController
public class OrderController {
	
	@Autowired
  private OrderRepository orderRepo;
	
	 @GetMapping("/orders")
	  public List<Orders> getAllOrderss(){
	    return orderRepo.findAll();
	  } 
	  
	  @GetMapping("/orders/find/{orderId}")
	  public Optional<Orders> getOrdersWithId(@PathVariable Integer orderId){
	    return orderRepo.findById(orderId);
	  } 
	  
	  @GetMapping("/orders/findByCompany")
	  public List<Orders> getCompanyWithCompany(@RequestParam Integer company){
	    return orderRepo.findByCompany(company);
	  } 
	  @GetMapping("/orders/findByItem")
	  public List<Orders> getCompanyWithItem(@RequestParam Integer item){
		  return orderRepo.findByItem(item);
	  } 
	  
	  @GetMapping("/orders/findByDays")
	  public List<Orders> getCompanyWithItem(@RequestParam Integer day1,Integer day2){
		  return orderRepo.findByDays(day1,day2);
	  } 
	  @GetMapping("/orders/purchases")
	  public List<Orders> getPurchases(){
		  return orderRepo.findByType("Purchase");
	  } 
	  @GetMapping("/orders/sales")
	  public List<Orders> getOrders(){
		  return orderRepo.findByType("Sale");
	  } 
	  
	  @PostMapping("/orders/newOrders")
	  public void addOrders(@RequestBody Orders newOrders){
        orderRepo.save(newOrders);
	  }
	  @DeleteMapping("/orders/delete/{orderId}")  
	  public boolean deleteOrders(@PathVariable Integer orderId)  
	  {  
			  if(!orderRepo.findById(orderId).equals(Optional.empty())) {
				  orderRepo.deleteById(orderId);
				  return true;
			  }
		  return false;
	  }  
	  
	  @PutMapping("/orders/edit/{orderId}")
	  public void editOrders(@PathVariable Integer orderId, @RequestParam Integer days){
		orderRepo.findById(orderId).get().setDays(days);
        orderRepo.save(orderRepo.findById(orderId).get());
	  }
	  
	  
}
