package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Warehouse")
@Embeddable
public class Warehouse  {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    private String name;
    public Warehouse() {
    	
    }
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Warehouse [id=" + id + ", name=" + name + "]";
	}
    
}