//package com.turbo.turbochargerswebservices.controller;
//
//import com.turbo.turbochargerswebservices.model.Turbocharger;
//import com.turbo.turbochargerswebservices.service.TodoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@CrossOrigin(origins = "http://localhost:4200")
//public class TodoController {
//
//    @Autowired
//    private TodoService todoService;
//
//    @GetMapping("/users/{username}/todos")
//    public List<Turbocharger> getAllTodos(@PathVariable String username) {
//        return todoService.findAll();
//    }
//
//    @GetMapping("/users/{username}/todos/{id}")
//    public Turbocharger getTodo(@PathVariable String username, @PathVariable Long id) {
//        return (Turbocharger) todoService.findById(id);
//    }
//
//    @DeleteMapping("/users/{username}/todos/{id}")
//    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable Long id) {
//        todoService.deleteById(id);
//        return ResponseEntity.ok().build();
//    }
//
//    @PostMapping("/users/{username}/todos")
//    public ResponseEntity<Turbocharger> saveTodo(@PathVariable String username, @RequestBody Turbocharger turbocharger) {
//        Turbocharger createdTurbocharger = todoService.save(turbocharger);
//        return new ResponseEntity<>(createdTurbocharger, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/users/{username}/todos/{id}")
//    public ResponseEntity<Turbocharger> updateTodo(@PathVariable String username, @PathVariable Long id, @RequestBody Turbocharger turbocharger) {
//        Turbocharger updatedTurbocharger = todoService.save(turbocharger);
//        return new ResponseEntity<>(updatedTurbocharger, HttpStatus.OK);
//    }
//
//}
