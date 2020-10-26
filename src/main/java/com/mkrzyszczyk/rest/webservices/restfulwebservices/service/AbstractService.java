package com.mkrzyszczyk.rest.webservices.restfulwebservices.service;

import com.mkrzyszczyk.rest.webservices.restfulwebservices.dao.AbstractDao;
import com.mkrzyszczyk.rest.webservices.restfulwebservices.model.AbstractEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;


public abstract class AbstractService<T extends AbstractEntity> {

    @Autowired
    private AbstractDao abstractDao;

       public List<T> findAll() {
        return abstractDao.findAll();
    }

    public T findById(Long id) {
        T t = null;
        Optional<T> optT = abstractDao.findById(id);
        if (optT.isPresent()) {
            t = optT.get();
        }
        return t;
    }

    public void deleteById(Long id) {
        abstractDao.deleteById(id);
    }


}
