package com.apirest.simplon.model;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name= "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private Long description;

    @Column(columnDefinition = "BOOLEAN DEFAULT true")
    private Boolean available;

    public Book() {}

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
