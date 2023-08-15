package com.skillstorm.project1.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

//transform the chocolate instance into an entity to map to the table
//this table has a one-to-many relationship with chocolate_factory (one flavor has many chocolates)
@Entity
@Table(name="flavors")
public class Flavor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment the id from the table
	private int id;
	@Column(length=255,name="flavors")
	private String flavorName;
	//one flavor has many chocolates
	
	@JsonBackReference
	@OneToMany
	Set<Chocolate> chocolates;
	
	

	public Flavor() {
		super();
	}
	
	

	public Flavor(int id, String flavorName, Set<Chocolate> chocolates) {
		super();
		this.id = id;
		this.flavorName = flavorName;
		this.chocolates = chocolates;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFlavorName() {
		return flavorName;
	}

	public void setFlavorName(String flavorName) {
		this.flavorName = flavorName;
	}

	public Set<Chocolate> getChocolates() {
		return chocolates;
	}

	public void setChocolates(Set<Chocolate> chocolates) {
		this.chocolates = chocolates;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chocolates == null) ? 0 : chocolates.hashCode());
		result = prime * result + ((flavorName == null) ? 0 : flavorName.hashCode());
		result = prime * result + id;
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
		Flavor other = (Flavor) obj;
		if (chocolates == null) {
			if (other.chocolates != null)
				return false;
		} else if (!chocolates.equals(other.chocolates))
			return false;
		if (flavorName == null) {
			if (other.flavorName != null)
				return false;
		} else if (!flavorName.equals(other.flavorName))
			return false;
		if (id != other.id)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Flavor [id=" + id + ", flavorName=" + flavorName + ", chocolates=" + chocolates + "]";
	}

	
	

}
