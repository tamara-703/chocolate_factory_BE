package com.skillstorm.project1test.controllers;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.project1test.models.Chocolate;
import com.skillstorm.project1test.services.ChocolateService;

@RestController
@RequestMapping("/chocolate/v1")
public class ChocolateController {
	
	//ask for one singleton instance of the chocolateService class
	//field inject first
	@Autowired
	ChocolateService chocolateService;
	
	@GetMapping 
	public List<Chocolate> FindAll()
	{
		return chocolateService.findAll();
				
	}
	
	@GetMapping("/{id}")
	public Chocolate findById(@PathVariable int id)
	{
		return chocolateService.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED) 
	public void create(@RequestBody Chocolate chocolate)
	{
		chocolateService.createChocolate(chocolate);
		
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public ResponseEntity<Chocolate> update(@RequestBody Chocolate chocolate, @PathVariable int id)
	{
		boolean status = chocolateService.update(chocolate, id);
		
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
		chocolateService.delete(id);
	}
	

}
