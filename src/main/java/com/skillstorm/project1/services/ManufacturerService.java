package com.skillstorm.project1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.skillstorm.project1.models.Flavor;
import com.skillstorm.project1.models.Manufacturer;
import com.skillstorm.project1.repositories.FlavorRepository;
import com.skillstorm.project1.repositories.ManufacturerRepository;

public class ManufacturerService {
	
	private ManufacturerRepository manufacturerRepo;
	
	@Autowired
	public ManufacturerService(ManufacturerRepository manufacturerRepo)
	{
		this.manufacturerRepo = manufacturerRepo;
	}
	
	//built in methods
	public List<Manufacturer> findAll()
	{
		return manufacturerRepo.findAll();
	}
	
	public Manufacturer findById(int id)
	{
		return manufacturerRepo.findById(id).get();
	}
	
	public Manufacturer createManufacturer(Manufacturer manufacturer)
	{
		manufacturerRepo.save(manufacturer);
		return manufacturer;
	}
	
	public boolean updateManufacturer(Manufacturer manufacturer, int id)
	{
		boolean status = false;
		if(id != 0)
		{
			manufacturerRepo.save(manufacturer);
			status = true;
		}
		
		return status;
		
	}
	
	public void deleteManufacturer(int id)
	{
		manufacturerRepo.deleteById(id); 
	}

}
