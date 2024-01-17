package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	@Query(value="SELECT Item.* FROM Item,Material WHERE Material.id=Item.id",nativeQuery = true)
	List<Item> findAllMaterials();
	@Query(value="SELECT Item.* FROM Item,Product WHERE Product.id=Item.id",nativeQuery = true)
	List<Item> findAllProducts();

}