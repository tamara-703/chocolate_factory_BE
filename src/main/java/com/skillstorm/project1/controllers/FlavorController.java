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
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.project1.models.Flavor;
import com.skillstorm.project1.services.FlavorService;

@RestController
@RequestMapping("/flavor")
public class FlavorController {
	
	@Autowired
	FlavorService flavorService;
	
	@GetMapping
	public List<Flavor> findAll()
	{
		return flavorService.findAll();
	}
	
	@GetMapping("/{id}")
	public Flavor findById(int id)
	{
		return flavorService.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<Flavor> createFlavor(@RequestBody Flavor flavor)
	{
		return new ResponseEntity<>(flavorService.createFlavor(flavor),HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Flavor> updateFlavor(Flavor flavor, @PathVariable int id)
	{
		if(id != 0)
		{
			flavorService.updateFlavor(flavor, id);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		} else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping
	public void deleteFlavor(int id)
	{
		flavorService.deleteFlavor(id);
	}

}
