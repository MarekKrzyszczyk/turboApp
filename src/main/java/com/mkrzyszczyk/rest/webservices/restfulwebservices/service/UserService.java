package com.mkrzyszczyk.rest.webservices.restfulwebservices.service;

import com.mkrzyszczyk.rest.webservices.restfulwebservices.dao.UserDao;
import com.mkrzyszczyk.rest.webservices.restfulwebservices.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractService {

    @Autowired
    private UserDao userDao;


    public void save(String username, String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(password);
        User user = new User();
        user.setUsername(username);
        user.setPassword(encodedPassword);
        userDao.save(user);
    }

}
