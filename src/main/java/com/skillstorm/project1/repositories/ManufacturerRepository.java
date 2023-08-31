package com.skillstorm.project1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skillstorm.project1.models.Flavor;
import com.skillstorm.project1.models.Manufacturer;

public interface ManufacturerRepository extends JpaRepository<Manufacturer,Integer> {
	
	@Query("SELECT m FROM Manufacturer m WHERE m.manufacturer = :manufacturer")
	public Manufacturer findByName(@Param("manufacturer") String manufacturer);

}
