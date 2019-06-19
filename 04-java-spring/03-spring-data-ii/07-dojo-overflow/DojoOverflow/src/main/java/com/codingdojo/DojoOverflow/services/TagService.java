package com.codingdojo.DojoOverflow.services;

import org.springframework.stereotype.Service;

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
}
