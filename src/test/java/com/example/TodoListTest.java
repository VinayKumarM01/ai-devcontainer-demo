package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TodoListTest {

    @Test
    void addAssignsIncrementingIds() {
        TodoList todoList = new TodoList();
        Todo first = todoList.add("Buy milk");
        Todo second = todoList.add("Walk dog");

        assertEquals(1, first.getId());
        assertEquals(2, second.getId());
    }

    @Test
    void listReturnsAddedTodos() {
        TodoList todoList = new TodoList();
        todoList.add("Buy milk");

        List<Todo> todos = todoList.list();

        assertEquals(1, todos.size());
        assertEquals("Buy milk", todos.get(0).getDescription());
    }

    @Test
    void deleteRemovesExistingTodo() {
        TodoList todoList = new TodoList();
        Todo todo = todoList.add("Buy milk");

        assertTrue(todoList.delete(todo.getId()));
        assertFalse(todoList.find(todo.getId()).isPresent());
    }

    @Test
    void deleteReturnsFalseForUnknownId() {
        TodoList todoList = new TodoList();

        assertFalse(todoList.delete(999));
    }
}
