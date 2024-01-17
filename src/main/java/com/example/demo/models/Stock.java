package com.example.demo.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Stock")
public class Stock implements Serializable{//composite key
	 @Id
	private StockId id;
	
	private Integer days;
	private Integer amount;
	public Stock() {
    	
    }
	public StockId getId() {
		return id;
	}
	public void setId(StockId id) {
		this.id = id;
	}
	public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Stock [id=" + id + ", days=" + days + ", amount=" + amount + "]";
	}
	
	
}