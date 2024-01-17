package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Material")
public class Material {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    public Material() {
    	
    }
    public Material(Integer id) {
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
		return "Material [id=" + id + "]";
	}
    
    
}