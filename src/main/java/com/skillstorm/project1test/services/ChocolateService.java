package com.skillstorm.project1test.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.project1test.models.Chocolate;
import com.skillstorm.project1test.repositories.ChocolateRepository;

@Service
public class ChocolateService {

	private ChocolateRepository repo;
	
	//Connect to the repository that will give us our CRUD methods using Constructor injection
	@Autowired
	public ChocolateService(ChocolateRepository repo)
	{
		this.repo = repo;
	}
	
	public List<Chocolate> findAll()
	{
		return repo.findAll();
	}
	
	public Chocolate findById(int id)
	{
		return repo.findById(id).get();
	}

	public void createChocolate(Chocolate chocolate)
	{
		repo.save(chocolate);
		
	}
	
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
	
	public void delete(int id)
	{
		
		repo.deleteById(id);
		
	}

}
