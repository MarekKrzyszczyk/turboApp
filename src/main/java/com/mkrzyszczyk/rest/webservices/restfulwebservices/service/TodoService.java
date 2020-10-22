package com.mkrzyszczyk.rest.webservices.restfulwebservices.service;

import com.mkrzyszczyk.rest.webservices.restfulwebservices.dao.TodoDao;
import com.mkrzyszczyk.rest.webservices.restfulwebservices.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoDao todoDao;

    public List<Todo> getAllTodos(String username) {
        return todoDao.findAll();
    }

    public Todo findById(Long id) {
        Todo todo = null;
        Optional<Todo> optTodo = todoDao.findById(id);
        if (optTodo.isPresent()) {
            todo = optTodo.get();
        }
        return todo;
    }

    public void deleteById(Long id) {
        todoDao.deleteById(id);
    }

    public Todo save(Todo todo) {
        todoDao.save(todo);
        return this.findById(todo.getId());
    }

}
