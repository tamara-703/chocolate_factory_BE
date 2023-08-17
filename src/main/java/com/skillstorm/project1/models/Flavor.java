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
	@Column(name= "flavor_id")
	private int id;
	@Column(length=255,name="flavors")
	private String name;
	//one flavor has many chocolates
	
	@JsonBackReference
	@OneToMany(mappedBy = "flavor")
	Set<Chocolate> chocolates;
	
	

	public Flavor() {
		super();
	}
	
	

	public Flavor(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.chocolates = chocolates;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFlavorName() {
		return name;
	}

	public void setFlavorName(String name) {
		this.name = name;
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
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (id != other.id)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Flavor [id=" + id + ", flavorName=" + name + ", chocolates=" + chocolates + "]";
	}

	
	

}
