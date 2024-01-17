package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Company")
public class Company {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    private String name;
    private String country;
    public Company() {
    }
    public Company(Integer id,String name,String country) {
    	this.id=id;
    	this.name=name;
    	this.country=country;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", country=" + country + "]";
	}
}
