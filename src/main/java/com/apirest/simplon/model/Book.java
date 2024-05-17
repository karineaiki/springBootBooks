package com.apirest.simplon.model;

import java.util.ArrayList;
import java.util.List;


import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
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

    @ManyToMany
    private List<Author> authorList = new ArrayList<>();

    @ManyToOne
     private Category category;

    public Book() {}

    public Long getId() {
        return this.id;
     }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
     }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getDescription() {
        return this.description;
    }

    public void setDescription(Long description) {
        this.description = description;
    }

    public Boolean isAvailable() {
        return this.available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public List<Author> getAuthorList() {
        return this.authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Boolean getAvailable() {
        return this.available;
    }

}
