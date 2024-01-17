package com.example.demo.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Columns;

@Entity
@Table(name = "Supply")
public class Supply implements Serializable {//composite key
	 @Id
    private SupplyId id;
    private Double price;
    public Supply() {
    	
    }
	public SupplyId getId() {
		return id;
	}
	public void setId(SupplyId id) {
		this.id = id;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
    
    
    
}