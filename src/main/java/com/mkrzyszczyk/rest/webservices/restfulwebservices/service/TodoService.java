package com.mkrzyszczyk.rest.webservices.restfulwebservices.service;

import com.mkrzyszczyk.rest.webservices.restfulwebservices.dao.TodoDao;
import com.mkrzyszczyk.rest.webservices.restfulwebservices.dao.UserDao;
import com.mkrzyszczyk.rest.webservices.restfulwebservices.model.Todo;
import com.mkrzyszczyk.rest.webservices.restfulwebservices.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class TodoService extends AbstractService {

    @Autowired
    private TodoDao todoDao;

    @Autowired
    private UserDao userDao;


    public Todo save(Todo todo) {
        todoDao.save(todo);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(todo.getUsername());
        User user = new User();
        user.setUsername(todo.getUsername());
        user.setPassword(encodedPassword);
        userDao.save(user);
        return (Todo) super.findById(todo.getId());
    }

}
