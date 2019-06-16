package com.codingdojo.relationshipsDL.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.relationshipsDL.models.License;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long> {
	List<License> findAll();

	
	
	
	
	
	
	
	
	
	
}  // end of repo interface
