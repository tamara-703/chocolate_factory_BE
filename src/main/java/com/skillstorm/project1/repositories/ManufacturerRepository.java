package com.skillstorm.project1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skillstorm.project1.models.Flavor;
import com.skillstorm.project1.models.Manufacturer;

public interface ManufacturerRepository extends JpaRepository<Manufacturer,String> {
	
	@Query("SELECT m FROM Manufacturer m WHERE m.manufacturer = :manufacturerName")
	public Manufacturer findByName(@Param("manufacturerName") String manufacturerName);

}
