package com.skillstorm.project1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.project1.models.Flavor;
import com.skillstorm.project1.repositories.FlavorRepository;

@Service
public class FlavorService {
	
	private FlavorRepository flavorRepo;
	
	@Autowired
	public FlavorService(FlavorRepository flavorRepo)
	{
		this.flavorRepo = flavorRepo;
	}
	
	//built in methods
	public List<Flavor> findAll()
	{
		return flavorRepo.findAll();
	}
	
	public Flavor findById(int id)
	{
		return flavorRepo.findById(id).get();
	}
	
	public Flavor createFlavor(Flavor flavor)
	{
		flavorRepo.save(flavor);
		return flavor;
	}
	
	public void updateFlavor(Flavor flavor, int id)
	{
		flavorRepo.save(flavor);
	}
	
	public void deleteFlavor(int id)
	{
		flavorRepo.deleteById(id); 
	}
	
	//custom methods

}
