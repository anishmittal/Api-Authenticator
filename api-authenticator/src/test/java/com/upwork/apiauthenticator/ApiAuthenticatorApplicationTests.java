package com.upwork.apiauthenticator;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import com.upwork.apiauthenticator.controller.PropertyController;
import com.upwork.apiauthenticator.entities.Property;

@SpringBootTest
class ApiAuthenticatorApplicationTests {

	@Autowired
	private PropertyController propController;
	
	@Test
	void findPropertyById() {
		ResponseEntity<Property> propReturned = propController.findPropertyById(1L);
		assertNotNull(propReturned.getBody());
	}
	
	@Test
	void findProperties() {
		List<Property> propReturned = propController.findProperties();
		assertNotNull(propReturned);
	}
	
	@Test
	void approveProperty() {
		Property prop = new Property("Prop1", 1);
		boolean propReturned = propController.approveProperty(prop);
		assertTrue(propReturned);
	}
	
	
	@Test
	void saveProperty() {
		Property prop = new Property("Prop1", 1);
		Mockito.verify(propController, Mockito.times(1)).saveProperty(prop);
	}

	@Test
	void updateProperty() {
		Property prop = new Property("Prop1", 1);
		Mockito.verify(propController, Mockito.times(1)).updateProperty(prop);
		
	}
}
