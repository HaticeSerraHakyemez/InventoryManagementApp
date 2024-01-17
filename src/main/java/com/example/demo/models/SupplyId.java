package com.example.demo.models;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class SupplyId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "supplier", referencedColumnName = "id")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "material", referencedColumnName = "id")
    private Material material;

    
    public SupplyId() {
    	
    }
    
	public Integer getSupplier() {
		return supplier.getId();
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Integer getMaterial() {
		return material.getId();
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return "SupplyId [supplier=" + supplier + ", material=" + material + "]";
	}
    
}
