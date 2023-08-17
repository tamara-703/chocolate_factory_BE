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
import com.skillstorm.project1.services.ChocolateService;

//@CrossOrigin("http://localhost:5001") //tells the backend that there are one or more local hosts running other than 8080 and connects 
//this localhost to other localhosts that are running
	//to have the backend ALL hosts available that are running on this pc, we use an *
@RestController
@RequestMapping("/chocolate/v1")
public class ChocolateController {
	
	//get all flavors (a flavor controller would be useful)
	
	//ask for one singleton instance of the chocolateService class
	//field inject first
	@Autowired
	ChocolateService chocolateService;
	
	@GetMapping //retrieves all chocolates
	public List<Chocolate> FindAll()
	{
		return chocolateService.findAll();
				
	}
	
	@GetMapping("/{id}") //retrieves a chocolate by its id
	public Chocolate findById(@PathVariable int id)
	{
		return chocolateService.findById(id);
	}
	
	@PostMapping //create new chocolate
	@ResponseStatus(code = HttpStatus.CREATED) 
	public ResponseEntity<Chocolate> create(@RequestBody Chocolate chocolate)
	{
		Chocolate createdChocolate = chocolateService.createChocolate(chocolate);
		
		return new ResponseEntity<>(createdChocolate,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/{id}") //edits an existing chocolate by its id
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
	
	@DeleteMapping("/{id}") //delete a chocolate by its id
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void delete(@PathVariable int id)
	{
		chocolateService.delete(id);
	}
	
	@GetMapping("/flavor") //getting all chocolates with the same flavor
	public ResponseEntity<List<Chocolate>> findAllChocolatesByFlavor(@RequestParam("flavor") String flavor) //@RequestParam takes any queries after our path 
																											//(anything after ? is stored within the @RequestParam parameters)
	{
		if(flavor != null)
		{
			return new ResponseEntity<>(chocolateService.findAllChocolatesByFlavor(flavor),HttpStatus.ACCEPTED);
		} else
		{
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	

}
