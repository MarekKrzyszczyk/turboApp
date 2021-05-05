package com.turbo.turbochargerswebservices.service;

import com.turbo.turbochargerswebservices.model.dto.AbstractBaseDto;
import javassist.NotFoundException;

import java.io.Serializable;
import java.util.List;

public interface AbstractBaseService<TDTO extends AbstractBaseDto, ID extends Serializable> {

    TDTO save(TDTO entity);

    List<TDTO> findAll();

    TDTO findById(ID entityId);

    TDTO updateById(ID entityId) throws NotFoundException;

    void delete(TDTO entity);

    void deleteById(ID entityId);

}
