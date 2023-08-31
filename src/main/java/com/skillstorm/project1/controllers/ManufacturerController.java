package com.skillstorm.project1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin("http://localhost:4200/")
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
	public ResponseEntity<Manufacturer> findById(@PathVariable int id)
	{
		return new ResponseEntity<>(manufacturerService.findById(id), HttpStatus.ACCEPTED);
				
	}
	
	@PutMapping ("/{id}") 
	public ResponseEntity<Manufacturer> update(@RequestBody Manufacturer manufacturer, @PathVariable int id)
	{
		boolean result = manufacturerService.updateManufacturer(manufacturer,id);
		
		if(result == true)
		{
			return new ResponseEntity<Manufacturer>(HttpStatus.ACCEPTED);
		} else
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
				
	}
	
	@PostMapping 
	@ResponseStatus(code = HttpStatus.CREATED) 
	public ResponseEntity<Manufacturer> create(@RequestBody Manufacturer manufacturer)
	{
		Manufacturer createdManufacturer = manufacturerService.createManufacturer(manufacturer);
		
		return new ResponseEntity<>(createdManufacturer,HttpStatus.CREATED);
		
	}
	

}
