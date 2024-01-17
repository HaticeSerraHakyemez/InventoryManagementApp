package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
	@Query(value="SELECT comp.* FROM Company comp, Supplier supp WHERE comp.id=supp.id",nativeQuery = true)
	List<Object[]> findAllSuppliers();
	
	@Query(value="SELECT comp.* FROM Company comp WHERE comp.id= ?1",nativeQuery = true)
	Optional<Object[]> findSupplierById(Integer customerId);
	
	@Query(value="SELECT Item.* FROM Supplier,Supply,Item WHERE Supplier.id= ?1 AND Supplier.id=Supply.supplier AND Supply.material=Item.id",nativeQuery = true)
	Optional<Object[]> findSuppliedItems(Integer customerId);
}