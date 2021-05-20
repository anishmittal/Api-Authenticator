package com.upwork.apiauthenticator.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upwork.apiauthenticator.entities.Property;
import com.upwork.apiauthenticator.service.PropertyService;
import com.upwork.apiauthenticator.util.Utility;

@RestController
@RequestMapping("/api/property")
public class PropertyController {

	@Autowired
	private PropertyService propService;
	
	/**
	 * Method to find a property by Id from the Database
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Property> findPropertyById(@PathVariable(value = "id") long id) {
		Optional<Property> prop = propService.getPropertyById(id);
		if(prop.isPresent()) {
			return ResponseEntity.ok().body(prop.get());
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping
	public List<Property> findProperties() {
		List<Property> properties = propService.getAllProperties();
		return properties;
	}
	
	/**
	 * Method to approve a Property
	 * @param id
	 * @return
	 */
	@GetMapping
	public boolean approveProperty(@Validated @RequestBody Property property) {
		Optional<Property> prop = propService.getPropertyById(property.getId());
		if(prop.isPresent()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Method to save a Property in the Database 
	 * @param property
	 */
	@PostMapping
	public void saveProperty(@Validated @RequestBody Property property) {
		propService.saveOrUpdate(property);
	}
	
	/**
	 * Method to completely update a property
	 * @param property
	 */
	
	@PutMapping
	public void updateProperty(@Validated @RequestBody Property property) {
		propService.update(property);
	}
	
}
