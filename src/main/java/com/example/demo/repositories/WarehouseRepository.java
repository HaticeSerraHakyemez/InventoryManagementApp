package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {

}