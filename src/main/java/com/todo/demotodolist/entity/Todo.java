package com.todo.demotodolist.entity;

import java.util.Optional;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private boolean completed;

    // Constructors, Getters, and Setters
    public Todo() {}

    public Todo(String description, boolean completed) {
        this.description = description;
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public boolean setCompleted(boolean completed) {
        return this.completed = completed;
    }

//    public Optional<Todo> map(Object object) {
//        return null;
//    }
}
