package com.mkrzyszczyk.rest.webservices.restfulwebservices.dao;

import com.mkrzyszczyk.rest.webservices.restfulwebservices.model.Todo;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoDao extends AbstractDao<Todo, Long> {


}
