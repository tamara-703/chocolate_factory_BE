package com.skillstorm.project1.repositories;

import org.springframework.data.domain.Pageable;
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
		
	
	//find all chocolates that has quantity less than 20000
	@Query("SELECT FROM Chocolate c WHERE c.quantity <= :quantity")
	List<Chocolate> findByQuantityLessThanEqual(@Param("quantity") long quantity);
	
	
	//find all chocolates by flavor
	@Query("SELECT FROM Chocolate c WHERE c.flavor.name = :flavorName")
	List<Chocolate> findByFlavorName(@Param("flavorName") String flavorName);

}
