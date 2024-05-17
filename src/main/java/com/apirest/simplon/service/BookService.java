package com.apirest.simplon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.apirest.simplon.model.Book;
import com.apirest.simplon.repository.BookRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepositoryInjected){
        this.bookRepository = bookRepositoryInjected;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        Optional<Book> optionalBook = this.bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            throw new EntityNotFoundException("No book found with id" + id);
        }
    }

    public List<Book> getBooksByTitle(String title) {
        return this.bookRepository.findByTitleContainingIgnoreCase(title);
    }

    public Book createBook(Book newBook) {
        return this.bookRepository.save(newBook);
    }


    public Book updateBook(Long id, Book bookData) {
        Optional<Book> existingBook = this.bookRepository.findById(id);
    
        if (existingBook.isPresent()) {
            Book updatedBook = existingBook.get();
            updatedBook.setId(id);
            updatedBook.setTitle(bookData.getTitle());
            updatedBook.setDescription(bookData.getDescription());
            updatedBook.setAvailable(bookData.isAvailable());
    
            return bookRepository.save(updatedBook);
        } else {
            throw new EntityNotFoundException("No book found with id " + id);
        }
    }
    

    public void deleteBook(Long id) {
        Optional<Book> optionalBook = this.bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            this.bookRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("No book found with id " + id);
        }
    }
}
