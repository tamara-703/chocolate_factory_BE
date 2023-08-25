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
	
	public Manufacturer findByName(String manufacturerName)
	{
		return manufacturerRepo.findByName(manufacturerName);
	}
	
	public Manufacturer createManufacturer(Manufacturer manufacturer)
	{
		manufacturerRepo.save(manufacturer);
		return manufacturer;
	}
	
	public boolean updateManufacturer(Manufacturer manufacturer, String manufacturerName)
	{
		@SuppressWarnings("deprecation")
		Manufacturer manufacturerToUpdate = manufacturerRepo.findByName(manufacturerName);
		
		boolean status = false;
		if(manufacturerToUpdate.getManufacturer().equals(manufacturerName))
		{
			manufacturerRepo.save(manufacturer);
			status = true;
		}
		
		return status;
		
	}
//	
//	public void deleteManufacturer(int id)
//	{
//		manufacturerRepo.deleteById(id); 
//	}

}
