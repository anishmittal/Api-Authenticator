package com.upwork.apiauthenticator.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.upwork.apiauthenticator.entities.Property;
import com.upwork.apiauthenticator.repository.PropertyRepository;

@Service
public class PropertyService {

	
	@Autowired
	PropertyRepository propRepo;
	
	//Getting all properties stored in the database
	public List<Property> getAllProperties(){
		List<Property> properties = new ArrayList<Property>();
		propRepo.findAll().forEach(props ->properties.add(props) );
		return properties;
	}
	
	//Getting a specific Property by using it's Id
	public Optional<Property> getPropertyById(long id) {
		return propRepo.findById(id);
	}
	
	//Saving a specific Property into the database
	public void saveOrUpdate(Property property) {
		propRepo.save(property);
	}
	
	//Deleting a specific property from database
	public void delete(long id) {
		propRepo.deleteById(id);
	}
	
	//Updating a property in the database
	public void update(Property prop) {
		propRepo.save(prop);
	}
	
	
}
