package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer> {
	
	@Query(value="SELECT * FROM Stock WHERE Stock.days >= ?1 AND Stock.days<= ?2",nativeQuery = true)
	List<Stock> findByDays(Integer day1, Integer day2);
	@Query(value="SELECT Stock.* FROM Stock,Warehouse WHERE Stock.warehouse = Warehouse.id AND Warehouse.name= ?1",nativeQuery = true)
	List<Stock> findByWarehouse(String warehouse);
	@Query(value="SELECT Stock.* FROM Stock,Item,Category WHERE Stock.item = Item.id AND Item.category=Category.name AND Category.type = ?1",nativeQuery = true)
	List<Stock> findByType(String type);
	@Query(value="SELECT * FROM Stock WHERE Stock.item = ?1",nativeQuery = true)
	List<Stock> findByItem(Integer item);
}