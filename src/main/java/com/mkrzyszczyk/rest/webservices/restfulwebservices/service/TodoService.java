package com.mkrzyszczyk.rest.webservices.restfulwebservices.service;

import com.mkrzyszczyk.rest.webservices.restfulwebservices.dao.TodoDao;
import com.mkrzyszczyk.rest.webservices.restfulwebservices.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoDao todoDao;

    public List<Todo> getAllTodos(String username) {
        return todoDao.findAll();
    }

    public void deleteById(Long id) {
        todoDao.deleteById(id);
    }

}
