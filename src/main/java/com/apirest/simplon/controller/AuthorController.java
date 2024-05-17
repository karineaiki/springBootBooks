package com.apirest.simplon.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.simplon.model.Author;
import com.apirest.simplon.repository.AuthorRepository;

@RestController
public class AuthorController {
    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepositoryInjected) {
        this.authorRepository = authorRepositoryInjected;
    }

    @GetMapping("/authors")
    public List<Author> getAuthors() {
        return this.authorRepository.findAll();
    }

    @PostMapping("/author")
    public Author postAuthor(@RequestBody Author author) {
        return this.authorRepository.save(author);
    }
}
