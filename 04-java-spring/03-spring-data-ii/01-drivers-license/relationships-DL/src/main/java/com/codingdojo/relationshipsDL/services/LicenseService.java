package com.codingdojo.relationshipsDL.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.relationshipsDL.models.License;
import com.codingdojo.relationshipsDL.models.Person;
import com.codingdojo.relationshipsDL.repositories.LicenseRepository;

@Service
public class LicenseService {
	private final LicenseRepository licenseRepository;

	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}

	// Retrieving all licenses
	public List<License> findAll() {
		return licenseRepository.findAll();
	}

	// Create a single license
	public void createLicense(License license) {
		Long number = licenseRepository.count();
		license.setNumber(String.format("%06d", number));
		licenseRepository.save(license);
	}

	// Return a single license
	public License findById(Long id) {
		return licenseRepository.findById(id).orElse(null);
	}

	public void joinPerson(License license, Person person) {
		license.setPerson(person);
		licenseRepository.save(license);
	}

} // end class LicenseService
