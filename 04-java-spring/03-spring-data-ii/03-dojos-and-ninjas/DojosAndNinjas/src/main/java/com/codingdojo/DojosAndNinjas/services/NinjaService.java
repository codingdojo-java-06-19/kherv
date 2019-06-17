package com.codingdojo.DojosAndNinjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.DojosAndNinjas.models.Dojo;
import com.codingdojo.DojosAndNinjas.models.Ninja;
import com.codingdojo.DojosAndNinjas.repositories.NinjaRepository;


@Service
public class NinjaService {
	private final NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}

	
	// Create a single ninja
	public void addNinja(Ninja ninja) {
		ninjaRepository.save(ninja);
	}
	
	
	
	
//	public void joinDojo(Ninja ninja, Dojo dojo) { //was in the license service and license is added after person and is then to be associated with the person 
//		ninja.setDojo(dojo);
//		ninjaRepository.save(ninja);
//	}

	
	
} // end NinjaService class
