package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.repositories.BookRepository;

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
    
	public Book findById(Long id) {
		Optional<Book> book = bookRepository.findById(id);
		
		if (book.isPresent()) {
			return book.get();
		}
		
		return null;
	}
    
    
	public Book updateBook(Long id, String title, String desc, String lang, Integer pages) {
		Book book = findById(id);
		
		book.setNumberOfPages(pages);
		book.setTitle(title);
		
		return updateBook(book);
	}
	
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}
	
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
    
    
} // end class
