package com.skillstorm.project1.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.skillstorm.project1.models.Chocolate;
import com.skillstorm.project1.models.Flavor;

//JpaRepository takes in the object that we want to map the crud operations to and 
//the data type of the id
@Repository
public interface ChocolateRepository extends JpaRepository<Chocolate,Integer> {
	
	//Built-in CRUD methods
	
	//find all
	
	//find by id
	
	//create (save)
	
	//update (save)
	
	//deleteById
		
	//Custom methods
	@Query("SELECT c FROM Chocolate c WHERE c.flavor.flavor = :flavor")
	List<Chocolate> findByFlavor(@Param("flavor") String flavor);

}
