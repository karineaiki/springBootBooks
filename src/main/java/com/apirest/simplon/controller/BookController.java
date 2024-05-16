package com.apirest.simplon.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.simplon.model.Book;
import com.apirest.simplon.service.BookService;

import jakarta.persistence.EntityNotFoundException;

@RestController
public class BookController {

    private BookService bookService;

    public BookController(BookService bookServiceInjected) {
        this.bookService = bookServiceInjected;
    }

    @GetMapping("/books")
    public List<Book> getBookList() {
        List<Book> allBooks = this.bookService.getAllBooks();
        return allBooks;
    }

    @GetMapping("/books/{id}") 
    public ResponseEntity<Book> getBookById(@PathVariable(name = "id") Long id) {
        try {
            return ResponseEntity.ok(this.bookService.getBookById(id));
        } catch (EntityNotFoundException exception) {
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/book")
    public Book postBook(@RequestBody Book book) {
        return this.bookService.createBook(book);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Boolean> deleteBookById(@pathVariable Long id) {
        try {
            this.bookService.deleteBook(id);
            return ResponseEntity.ok(true);
        } catch (EntityNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookData) {
        try {
            return ResponseEntity.ok(this.bookService.updateBook(id, bookData));
        } catch (EntityNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/books/title/{title}")
    public List<Book> getBooksByTitle(@PathVariable String titles) {
        return this.bookService.getBooksByTitle(titles);
    }
}
