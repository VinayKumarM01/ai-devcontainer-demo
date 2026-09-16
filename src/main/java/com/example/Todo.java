package com.example;

public class Todo {

    private final int id;
    private final String description;

    public Todo(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return id + ": " + description;
    }
}
