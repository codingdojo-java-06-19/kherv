package com.hervey.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hervey.app.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	//User findByUserName(String username);
	User findByUsername (String username);

}
