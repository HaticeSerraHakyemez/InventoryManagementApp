package com.example.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.Material;

public interface MaterialRepository extends JpaRepository<Material, Integer> {
	@Query(value="SELECT sum(Orders.amount) FROM Material, Orders WHERE Material.id= ?1 AND Material.id=Orders.item ",nativeQuery = true)
	Integer findMaterialOrders(Integer materialId);
}