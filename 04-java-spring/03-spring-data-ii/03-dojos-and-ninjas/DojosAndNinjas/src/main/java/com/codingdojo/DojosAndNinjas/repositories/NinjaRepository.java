package com.codingdojo.DojosAndNinjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.DojosAndNinjas.models.Ninja;



@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {
	//List<Ninja> findAllByDojo();  //needed to show all Ninjas for given Dojo on the Dojo page
	//List<Ninja> findAllByDojoID(); // or this one needed to show all Ninjas for given Dojo on the Dojo page
	// List<Ninja> findAllByDojoIsNull(); //needed when creating Dojo to select Nin
	List<Ninja> findAll();
	
	
	
	
	
	
	
	
	
} // end Repository interface

