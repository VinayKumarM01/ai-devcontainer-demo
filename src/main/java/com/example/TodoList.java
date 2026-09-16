package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TodoList {

    private final List<Todo> todos = new ArrayList<>();
    private int nextId = 1;

    public Todo add(String description) {
        Todo todo = new Todo(nextId++, description);
        todos.add(todo);
        return todo;
    }

    public List<Todo> list() {
        return List.copyOf(todos);
    }

    public boolean delete(int id) {
        return todos.removeIf(todo -> todo.getId() == id);
    }

    public Optional<Todo> find(int id) {
        return todos.stream().filter(todo -> todo.getId() == id).findFirst();
    }
}
