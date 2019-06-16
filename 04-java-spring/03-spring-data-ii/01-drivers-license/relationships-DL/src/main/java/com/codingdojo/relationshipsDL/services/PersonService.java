package com.codingdojo.relationshipsDL.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.relationshipsDL.models.License;
import com.codingdojo.relationshipsDL.models.Person;
import com.codingdojo.relationshipsDL.repositories.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository)  {
		this.personRepository = personRepository;
	}

	//create a person
	public Person createPerson(Person p) {
		return personRepository.save(p);
	}
	
	//Return all persons with licenses
	public List<Person> allPersons() {
		return personRepository.findAll();
	}
	
	//Returns all persons who don't have a license
	public List<Person> getAllWithNoLicense() {
		return personRepository.findAllByLicenseIsNull();
	}
	
	//Adds a license to a person
	public void addLicenseToPerson(License license, Person person) {
		person.setLicense(license);
		personRepository.save(person);
	}
	
	//Finds a person by a String through a form
	public Person findPerson(String id) {
		return findPerson(Long.parseLong(id));
	}
	
	//Finds a person by an integer
	public Person findPerson(Long id) {
		Optional<Person> optionalPerson = personRepository.findById(id);
		if(optionalPerson.isPresent()) {
			return optionalPerson.get();
		}
		else {
			return null;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
} // end Person Service class
