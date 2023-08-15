package com.skillstorm.project1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillstorm.project1.models.Flavor;
import com.skillstorm.project1.models.Manufacturer;

public interface ManufacturerRepository extends JpaRepository<Manufacturer,Integer> {

}
