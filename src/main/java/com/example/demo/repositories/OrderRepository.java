package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer> {
	@Query(value="SELECT * FROM Orders x WHERE x.company = ?1",nativeQuery = true)
	List<Orders> findByCompany(Integer company);
	@Query(value="SELECT * FROM Orders x WHERE x.item = ?1",nativeQuery = true)
	List<Orders> findByItem(Integer item);
	@Query(value="SELECT * FROM Orders x WHERE x.days >= ?1 AND x.days<= ?2",nativeQuery = true)
	List<Orders> findByDays(Integer day1,Integer day2);
	@Query(value="SELECT * FROM Orders x WHERE x.type = ?1",nativeQuery = true)
	List<Orders> findByType(String type);
}