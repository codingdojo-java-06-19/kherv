package com.codingdojo.events.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.events.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findbyEmail (String email);

}
