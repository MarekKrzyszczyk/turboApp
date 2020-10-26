package com.mkrzyszczyk.rest.webservices.restfulwebservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface AbstractDao<T, ID extends Serializable> extends JpaRepository<T, ID> {


}
