package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	@Query(value="SELECT Company.id AS id, Company.name AS name, Company.country AS country FROM Company,Customer WHERE Company.id=Customer.id",nativeQuery = true)
	List<Object[]> findAllCustomers();
}