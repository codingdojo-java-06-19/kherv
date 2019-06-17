package com.codingdojo.DojosAndNinjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.DojosAndNinjas.models.Dojo;
import com.codingdojo.DojosAndNinjas.models.Ninja;
import com.codingdojo.DojosAndNinjas.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepository;

	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}


	
	//Return all Dojos
	public List<Dojo> findAll(){
		return dojoRepository.findAll();
	}
	
	
	//Return one Dojo
	public Dojo findOne(Long id) {
		return dojoRepository.findById(id).orElse(null);
	}
	
//	//Returns all ninjas for given Dojo
//	public List<Ninja> getAllForDojo(Long id) {
//		return ninjaRepository.findAllByDojoID();
//	}
	
	
	
	
	
	
	// create a dojo
	public Dojo create(Dojo dojo) {
		return dojoRepository.save(dojo);
	}
	
	
}
