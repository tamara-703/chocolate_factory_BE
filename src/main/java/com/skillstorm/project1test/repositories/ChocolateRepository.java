package com.skillstorm.project1test.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.skillstorm.project1test.models.Chocolate;

//JpaRepository takes in the object that we want to map the crud operations to and 
//the data type of the id
public interface ChocolateRepository extends JpaRepository<Chocolate,Integer> {
	
	//Built in CRUD methods
	
	//get all
	
	//get by id
	
	//create 
	
	//update
	
	//delete
		
	//Custom methods

}
