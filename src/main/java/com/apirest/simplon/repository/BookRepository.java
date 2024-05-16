package com.apirest.simplon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirest.simplon.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    public List<Book> findByTitleContainingIgnoreCase(String title);
}
