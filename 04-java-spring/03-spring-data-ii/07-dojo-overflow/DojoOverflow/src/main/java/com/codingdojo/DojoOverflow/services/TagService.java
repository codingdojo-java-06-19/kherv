package com.codingdojo.DojoOverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.DojoOverflow.models.Question;
import com.codingdojo.DojoOverflow.models.Tag;
import com.codingdojo.DojoOverflow.repositories.QuestionRepository;
import com.codingdojo.DojoOverflow.repositories.TagRepository;

@Service
public class TagService {
	private final TagRepository tagRepository;
	private final QuestionRepository questionRepository;
	
	public TagService(TagRepository tagRepository, QuestionRepository questionRepository) {
		this.tagRepository = tagRepository;
		this.questionRepository = questionRepository;
	}
		
		
	public void saveTag(Tag fTag) {
		tagRepository.save(fTag);
	}

	public void addTagToQuestion(String strTag, Question question) {
		Tag tag = findOrCreateTag(strTag);
		addTagToQuestion(tag, question);
	}
	
	
	public void addTagToQuestion(Tag tag, Question question) {
		
		question.addTag(tag);
		questionRepository.save(question);
	}
		
	
	//Find if Tag already exists in database
	public Tag findOrCreateTag(String subject) {
		Tag foundTag = tagRepository.findBySubject(subject).orElse(null);
		if (foundTag==null) {
			System.out.println("Tag is null");
			foundTag = new Tag();
			foundTag.setSubject(subject);
			saveTag(foundTag);
		}
		System.out.println("Found tag is: "+ foundTag);
		return foundTag;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
