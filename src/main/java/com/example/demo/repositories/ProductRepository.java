package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	@Query(value="SELECT sum(Orders.amount) FROM Product, Orders WHERE Product.id= ?1 AND Product.id=Orders.item ",nativeQuery = true)
	Integer findProductOrders(Integer productId);
	@Query(value="SELECT sum(Orders.amount)-sum(Stock.amount) FROM Product, Orders,Stock WHERE Product.id= ?1 AND Product.id=Orders.item AND Product.id=Stock.item ",nativeQuery = true)
	Integer findProductNeed(Integer productId);
}