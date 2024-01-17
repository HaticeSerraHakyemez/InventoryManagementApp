package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Supplier")
public class Supplier {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    
    public Supplier() {
    	
    }
	public Supplier(Integer id) {
		this.id=id;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Supplier [id=" + id + "]";
	}
    
    
}