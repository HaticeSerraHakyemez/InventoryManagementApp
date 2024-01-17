package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
	@Query(value="SELECT * FROM Company comp WHERE comp.country = ?1",nativeQuery = true)
	List<Company> findByCountry(String country);
	
	@Query(value="SELECT Company.* FROM Company,Customer WHERE Customer.id=Company.id",nativeQuery = true)
	List<Company> findAllCustomers();
	
	@Query(value="SELECT Company.* FROM Company,Supplier WHERE Company.id=Supplier.id",nativeQuery = true)
	List<Company> findAllSuppliers();
	
}