package com.apirest.simplon.model;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name= "books")
public class Book {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private Long description;
    @Column
    private Boolean available;

    public Book() {}

    // public Book(Long id, String title, Long description, Boolean available) {
    //     this.id = id;
    //     this.title = title;
    //     this.description = description;
    //     this.available = available;
    // }

    public Long getBookId() {
        return this.id;
     }

    public void setBookId(Long id) {
        this.id = id;
    }

    public String getBookTitle() {
        return this.title;
     }

    public void setBookTitle(String title) {
        this.title = title;
    }

    public Long getBookDescription() {
        return this.description;
    }

    public void setBookDescription(Long description) {
        this.description = description;
    }

    public Boolean bookIsAvailable() {
        return this.available;
    }

    public void setBooksIsAvailable(Boolean available) {
        this.available = available;
    }
}
