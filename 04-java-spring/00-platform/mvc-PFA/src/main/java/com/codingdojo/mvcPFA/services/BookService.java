package com.codingdojo.mvcPFA.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.mvcPFA.models.Book;
import com.codingdojo.mvcPFA.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll(); //calls method in the Repository
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b); //works because Repository extended the CrudRepository
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
}
