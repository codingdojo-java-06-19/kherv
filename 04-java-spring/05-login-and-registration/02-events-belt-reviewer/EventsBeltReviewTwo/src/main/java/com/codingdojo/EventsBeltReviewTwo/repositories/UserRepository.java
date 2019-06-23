package com.codingdojo.EventsBeltReviewTwo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.EventsBeltReviewTwo.models.Event;
import com.codingdojo.EventsBeltReviewTwo.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findByEmail (String email);

}




