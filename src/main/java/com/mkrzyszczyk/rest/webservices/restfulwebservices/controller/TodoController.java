package com.mkrzyszczyk.rest.webservices.restfulwebservices.controller;

import com.mkrzyszczyk.rest.webservices.restfulwebservices.model.Todo;
import com.mkrzyszczyk.rest.webservices.restfulwebservices.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username) {
        return todoService.findAll();
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username, @PathVariable Long id) {
        return (Todo) todoService.findById(id);
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable Long id) {
        todoService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/users/{username}/todos")
    public ResponseEntity<Todo> saveTodo(@PathVariable String username, @RequestBody Todo todo) {
        Todo createdTodo = todoService.save(todo);
        return new ResponseEntity<>(createdTodo, HttpStatus.CREATED);
    }

    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable Long id, @RequestBody Todo todo) {
        Todo updatedTodo = todoService.save(todo);
        return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
    }

}
