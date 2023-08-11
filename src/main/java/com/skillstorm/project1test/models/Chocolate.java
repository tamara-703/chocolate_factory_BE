package com.skillstorm.project1test.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//transform the chocolate instance into an entity to map to the table
@Entity
public class Chocolate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment the id from the table
	private int id;
	private String brand_name;
	private String manufacturer;
	private String manufacturer_address;
	
	
	public Chocolate() {
		super();
	}
	
	
	
	public Chocolate(int id, String brand_name, String manufacturer, String manufacturer_address) {
		super();
		this.id = id;
		this.brand_name = brand_name;
		this.manufacturer = manufacturer;
		this.manufacturer_address = manufacturer_address;
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
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getManufacturer_address() {
		return manufacturer_address;
	}
	public void setManufacturer_address(String manufacturer_address) {
		this.manufacturer_address = manufacturer_address;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand_name == null) ? 0 : brand_name.hashCode());
		result = prime * result + id;
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + ((manufacturer_address == null) ? 0 : manufacturer_address.hashCode());
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
		if (id != other.id)
			return false;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (manufacturer_address == null) {
			if (other.manufacturer_address != null)
				return false;
		} else if (!manufacturer_address.equals(other.manufacturer_address))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Chocolate [id=" + id + ", brand_name=" + brand_name + ", manufacturer=" + manufacturer
				+ ", manufacturer_address=" + manufacturer_address + "]";
	}
	
	
	
	

}
