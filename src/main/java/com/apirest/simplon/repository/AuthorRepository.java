package com.apirest.simplon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.simplon.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    
}
