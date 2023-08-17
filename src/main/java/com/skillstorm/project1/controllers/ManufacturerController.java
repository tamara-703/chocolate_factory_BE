package com.skillstorm.project1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.project1.models.Chocolate;
import com.skillstorm.project1.models.Flavor;
import com.skillstorm.project1.models.Manufacturer;
import com.skillstorm.project1.services.ChocolateService;
import com.skillstorm.project1.services.ManufacturerService;

@RestController
@RequestMapping("/manufacturer")
public class ManufacturerController {
	
	@Autowired
	ManufacturerService manufacturerService;
	
	@GetMapping
	public List<Manufacturer> FindAll()
	{
		return manufacturerService.findAll();
				
	}
	
	@GetMapping("/{id}") 
	public Manufacturer findById(@PathVariable int id)
	{
		return manufacturerService.findById(id);
	}
	
	@PostMapping 
	@ResponseStatus(code = HttpStatus.CREATED) 
	public ResponseEntity<Manufacturer> create(@RequestBody Manufacturer manufacturer)
	{
		Manufacturer createdManufacturer = manufacturerService.createManufacturer(manufacturer);
		
		return new ResponseEntity<>(createdManufacturer,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/{id}") 
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public ResponseEntity<Manufacturer> update(@RequestBody Manufacturer manufacturer, @PathVariable int id)
	{
		boolean status = manufacturerService.updateManufacturer(manufacturer, id);
		
		if(status == true)
		{
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		} else
		{
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@DeleteMapping("/{id}") 
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void delete(@PathVariable int id)
	{
		manufacturerService.deleteManufacturer(id);
	}
	

}
