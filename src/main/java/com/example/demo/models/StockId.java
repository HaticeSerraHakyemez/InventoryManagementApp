package com.example.demo.models;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Embeddable
public class StockId implements Serializable {

	@ManyToOne
    @JoinColumn(name = "item", referencedColumnName = "id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "warehouse", referencedColumnName = "id")
    private Warehouse warehouse;
    
    public StockId() {
    	
    }
	public Integer getItem() {
		return item.getId();
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Integer getWarehouse() {
		return warehouse.getId();
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	@Override
	public String toString() {
		return "StockId [item=" + item + ", warehouse=" + warehouse + "]";
	}

    
}
