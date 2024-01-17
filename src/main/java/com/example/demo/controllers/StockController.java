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

import com.example.demo.models.Stock;
import com.example.demo.repositories.StockRepository;

@RestController
public class StockController {
	
	@Autowired
  private StockRepository stockRepo;
	
	 @GetMapping("/stocks")
	  public List<Stock> getAllStocks(){
	    return stockRepo.findAll();
	  } 
	  @GetMapping("/stocks/findByDays")
	  public List<Stock> getStockWithDays(@RequestParam Integer day1,@RequestParam Integer day2){
	    return stockRepo.findByDays(day1,day2);
	  } 
	  @GetMapping("/stocks/findByWarehouse")
	  public List<Stock> getStockWithWarehouse(@RequestParam String warehouse){
	    return stockRepo.findByWarehouse(warehouse);
	  } 
	  @GetMapping("/stocks/findByType")
	  public List<Stock> getStockWithType(@RequestParam String type){
	    return stockRepo.findByType(type);
	  } 
	  @GetMapping("/stocks/findByItem")
	  public List<Stock> getStockWithItem(@RequestParam Integer item){
	    return stockRepo.findByItem(item);
	  } 
	  //
	  @PostMapping("/stocks/newStock")
	  public void addStock(@RequestBody Stock newStock){
        stockRepo.save(newStock);
	  }
	  
	  @DeleteMapping("/stocks/delete/{stockId}")  
	  public boolean deleteStock(@PathVariable Integer stockId)  
	  {  
			  if(!stockRepo.findById(stockId).equals(Optional.empty())) {
				  stockRepo.deleteById(stockId);
				  return true;
			  }
		  return false;
	  }  
	  
	  @PutMapping("/stocks/edit/days/{stockId}")
	  public void editStockDays(@PathVariable Integer stockId, @RequestParam Integer days){
		stockRepo.findById(stockId).get().setDays(days);
        stockRepo.save(stockRepo.findById(stockId).get());
	  }
	  
	  @PutMapping("/stocks/edit/amount/{stockId}")
	  public void editStockAmount(@PathVariable Integer stockId, @RequestParam Integer amount){
		  stockRepo.findById(stockId).get().setAmount(amount);
		  stockRepo.save(stockRepo.findById(stockId).get());
	  }
	  
	  
}
