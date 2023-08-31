package com.skillstorm.project1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.project1.models.Flavor;
import com.skillstorm.project1.models.Manufacturer;
import com.skillstorm.project1.repositories.FlavorRepository;
import com.skillstorm.project1.repositories.ManufacturerRepository;

@Service
public class ManufacturerService {
	
	private ManufacturerRepository manufacturerRepo;
	
	@Autowired
	public ManufacturerService(ManufacturerRepository manufacturerRepo)
	{
		this.manufacturerRepo = manufacturerRepo;
	}
	
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
		@SuppressWarnings("deprecation")
		int manufacturerToUpdate = manufacturerRepo.getById(id).getId();
		
		boolean status = false;
		
		
		if(manufacturerToUpdate != 0)
		{
			if(manufacturerToUpdate == id)
			{
				manufacturerRepo.save(manufacturer);
				status = true;
			}
		}
		
		return status;
		
	}
	
}
