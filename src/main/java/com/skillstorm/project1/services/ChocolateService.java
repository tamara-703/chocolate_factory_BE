package com.skillstorm.project1.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.project1.models.Chocolate;
import com.skillstorm.project1.models.Flavor;
import com.skillstorm.project1.repositories.ChocolateRepository;

@Service
public class ChocolateService {

	private ChocolateRepository repo;
	
	//Connect to the repository that will give us our CRUD methods using Constructor injection
	@Autowired
	public ChocolateService(ChocolateRepository repo)
	{
		this.repo = repo;
	}
	
	//returns a list of chocolates
	public List<Chocolate> findAll()
	{
		return repo.findAll();
	}
	
	//return a chocolate by its id
	public Chocolate findById(int id)
	{
		return repo.findById(id).get();
	}

	//create new chocolate
	public Chocolate createChocolate(Chocolate chocolate)
	{
		repo.save(chocolate);
		return chocolate;
		
	}
	
	//update an existing chocolate
	public boolean update(Chocolate chocolate, int id)
	{
		@SuppressWarnings("deprecation")
		int chocolateToUpdate = repo.getById(id).getId();
		boolean status = false;
		
		if(chocolateToUpdate == id)
		{
			repo.save(chocolate);
			status = true;
		}
		
		return status;
	}
	
	//delete a chocolate by its id
	public void delete(int id)
	{
		
		repo.deleteById(id);
		
	}
	
	//custom methods
	public List<Chocolate> findAllChocolatesByFlavor(String flavor)
	{
		return repo.findByFlavor(flavor);
	}

}
