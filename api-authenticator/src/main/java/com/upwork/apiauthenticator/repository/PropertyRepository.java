package com.upwork.apiauthenticator.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.upwork.apiauthenticator.entities.Property;

@Repository
public interface PropertyRepository extends CrudRepository<Property, Long>{

}
