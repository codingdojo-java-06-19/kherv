package com.codingdojo.mvcPFA.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvcPFA.models.Book;




@Repository
public interface BookRepository extends CrudRepository<Book, Long>{ //Note that Book is the name of the model...or the model class
	List<Book> findAll();
	List<Book> findByDescriptionContaining(String search);
	
}
