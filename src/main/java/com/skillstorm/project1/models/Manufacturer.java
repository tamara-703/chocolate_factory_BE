package com.skillstorm.project1.models;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="manufacturer")
public class Manufacturer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "manufacturer_id")
	private int id;
	@Column(length=255, name="manufacturer")
	private String manufacturer;
	@Column(length=255, name="manufacturer_address")
	private String manufacturerAddress;
	@Column(name="capacity")
	private int capacity;
	
//	@JsonBackReference
//	@OneToOne
//	Chocolate chocolate;


	public Manufacturer() {
		super();
	}
	
	
	public Manufacturer(int id, String manufacturer, String manufacturerAddress, int capacity) {
		super();
		this.id = id;
		this.manufacturer = manufacturer;
		this.manufacturerAddress = manufacturerAddress;
		this.capacity = capacity;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getManufacturer() {
		return manufacturer;
	}


	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}


	public String getManufacturerAddress() {
		return manufacturerAddress;
	}


	public void setManufacturerAddress(String manufacturerAddress) {
		this.manufacturerAddress = manufacturerAddress;
	}


	public long getCapacity() {
		return capacity;
	}


	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (capacity ^ (capacity >>> 32));
		result = prime * result + id;
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + ((manufacturerAddress == null) ? 0 : manufacturerAddress.hashCode());
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
		Manufacturer other = (Manufacturer) obj;
		if (capacity != other.capacity)
			return false;
		if (id != other.id)
			return false;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (manufacturerAddress == null) {
			if (other.manufacturerAddress != null)
				return false;
		} else if (!manufacturerAddress.equals(other.manufacturerAddress))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Manufacturer [id=" + id + ", manufacturer=" + manufacturer + ", manufacturerAddress="
				+ manufacturerAddress + ", capacity=" + capacity + "]";
	}
	
	

}
