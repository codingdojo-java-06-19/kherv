package com.codingdojo.relationshipsDL.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.relationshipsDL.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
	List<Person> findAllByLicenseIsNull();
	List<Person> findAll();
	
} // end of Person repo interface
