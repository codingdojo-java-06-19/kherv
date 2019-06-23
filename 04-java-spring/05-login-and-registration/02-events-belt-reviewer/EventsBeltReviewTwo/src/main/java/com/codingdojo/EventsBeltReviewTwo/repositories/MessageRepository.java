package com.codingdojo.EventsBeltReviewTwo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.EventsBeltReviewTwo.models.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {
	

}
