package com.codingdojo.Languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.Languages.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> { // < >contains the class of the model file, Long is type of its ID
	List<Language> findAll();
	List<Language> findByVersionContaining(String search);
	
	
	
} // end of repo interface
