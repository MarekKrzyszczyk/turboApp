package com.turbo.turbochargerswebservices.service;

import com.turbo.turbochargerswebservices.model.AbstractBaseEntity;
import com.turbo.turbochargerswebservices.repository.AbstractBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public abstract class AbstractBaseServiceImpl<T extends AbstractBaseEntity, ID extends Serializable> implements AbstractBaseService<T, ID> {

    private final AbstractBaseRepository<T, ID> abstractBaseRepository;

    @Autowired
    public AbstractBaseServiceImpl(AbstractBaseRepository<T, ID> abstractBaseRepository) {
        this.abstractBaseRepository = abstractBaseRepository;
    }

    @Override
    public T save(T entity) {
        return abstractBaseRepository.save(entity);
    }

    @Override
    public List<T> findAll() {
        return abstractBaseRepository.findAll();
    }

    @Override
    public T findById(ID entityId) {
        Optional<T> optional = abstractBaseRepository.findById(entityId);
        return optional.orElse(null);
    }

    @Override
    public T update(T entity) {
        return abstractBaseRepository.save(entity);
    }

    @Override
    public T updateById(T entity, ID entityId) {
        Optional<T> optional = abstractBaseRepository.findById(entityId);
        if(optional.isPresent()){
            return abstractBaseRepository.save(entity);
        }else{
            return null;
        }
    }

    @Override
    public void delete(T entity) {
        abstractBaseRepository.delete(entity);
    }

    @Override
    public void deleteById(ID entityId) {
        abstractBaseRepository.deleteById(entityId);
    }
}
