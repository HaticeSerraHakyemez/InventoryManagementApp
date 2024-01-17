package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.Supply;

public interface SupplyRepository extends JpaRepository<Supply, Integer> {
	@Query(value="SELECT * FROM Supply WHERE Supply.material= ?1 ORDER BY price ASC",nativeQuery = true)
	List<Supply> findByMaterial(Integer material);
	
	@Query(value="SELECT * FROM Supply WHERE Supply.supplier= ?1",nativeQuery = true)
	List<Supply> findByCompany(Integer company);
}