package com.codingdojo.Languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.Languages.models.Language;
import com.codingdojo.Languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository languageRepository;  //languageRepository will call all the methods we have such as findAll
	
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	//returns all the languages
	public List<Language> allLanguages() {
		return languageRepository.findAll();
	}
	
	//create a language
	public Language createLanguage(Language l) {
		return languageRepository.save(l); //works because Repository extended the CrudRepository
	}
	
	//retrieves a language
	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if(optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		}
		else {
			return null;
		}
	}
	
	//find one language by id
	public Language findbyId(Long id) {
		Optional<Language> language = languageRepository.findById(id);
		if (language.isPresent()) {
			return language.get();
		}
		return null;
	}
	
	//update
	public Language updateLanguage(Long id, String langName, String creator, String version) { //include types and field names in param list
		Language language = findbyId(id);
		
		language.setCreator(creator);
		language.setLangName(langName);
		language.setVersion(version);
		return updatedLanguage(language);
	}
	
	private Language updatedLanguage(Language language) {
		// TODO Auto-generated method stub
		return languageRepository.save(language);
	}

	//delete
	public void deleteLanguage(Long id) {
		languageRepository.deleteById(id);
	}
	
	public LanguageRepository getLanguageRepository() {
		return languageRepository;
	}

}
