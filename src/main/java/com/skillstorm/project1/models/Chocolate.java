package com.skillstorm.project1.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//transform the chocolate instance into an entity to map to the table
//this table has many-to-one relationship with flavors (many chocolates have one flavor)
//and a one-to-one (one chocolate can only have one flavor)
@Entity
@Table(name="chocolate_factory")
public class Chocolate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment the id from the table
	private int id; //chocolate_id
	@Column(length=255, name="brand_name")
	private String brand_name; //brand_name
	@Column(length=255, name="quantity")
	private int quantity; //quantity
	
	@JoinColumn(name="manufacturer_id")
	@OneToOne //one chocolate has only one manufacturer
	private Manufacturer manufacturer; //foreign key for manufacturer table

	//indicate foreign key
	@JoinColumn(name="flavor_id")
	@ManyToOne //many chocolates can point to one flavor
	private Flavor flavor; 
	
	
	public Chocolate() {
		super();
	}


	public Chocolate(int id, String brand_name, int quantity, Manufacturer manufacturer) {
		super();
		this.id = id;
		this.brand_name = brand_name;
		this.quantity = quantity;
		this.manufacturer = manufacturer;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getBrand_name() {
		return brand_name;
	}


	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Manufacturer getManufacturer() {
		return manufacturer;
	}


	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand_name == null) ? 0 : brand_name.hashCode());
		result = prime * result + ((flavor == null) ? 0 : flavor.hashCode());
		result = prime * result + id;
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + quantity;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chocolate other = (Chocolate) obj;
		if (brand_name == null) {
			if (other.brand_name != null)
				return false;
		} else if (!brand_name.equals(other.brand_name))
			return false;
		if (flavor == null) {
			if (other.flavor != null)
				return false;
		} else if (!flavor.equals(other.flavor))
			return false;
		if (id != other.id)
			return false;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Chocolate [id=" + id + ", brand_name=" + brand_name + ", quantity=" + quantity + ", manufacturer="
				+ manufacturer + ", flavor=" + flavor + "]";
	}
	
	

}
