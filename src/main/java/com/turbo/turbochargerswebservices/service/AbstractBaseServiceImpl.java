package com.turbo.turbochargerswebservices.service;

import com.turbo.turbochargerswebservices.model.dto.AbstractBaseDto;
import com.turbo.turbochargerswebservices.model.dto.CustomMapper;
import com.turbo.turbochargerswebservices.model.entity.AbstractBaseEntity;
import com.turbo.turbochargerswebservices.repository.AbstractBaseRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public abstract class AbstractBaseServiceImpl<T extends AbstractBaseEntity, TDTO extends AbstractBaseDto, ID extends Serializable>
        implements AbstractBaseService<TDTO, ID> {

    private final AbstractBaseRepository<T, ID> abstractBaseRepository;
    private final CustomMapper<T, TDTO> customMapper;

    @Autowired
    public AbstractBaseServiceImpl(AbstractBaseRepository<T, ID> abstractBaseRepository, CustomMapper<T, TDTO> customMapper) {
        this.abstractBaseRepository = abstractBaseRepository;
        this.customMapper = customMapper;
    }

    @Override
    public TDTO save(TDTO dto) {
        T entity = customMapper.mapToEntity(dto);
        return customMapper.mapToDto(abstractBaseRepository.save(entity));
    }

    @Override
    public List<TDTO> findAll() {
        return customMapper.mapToDtoList(abstractBaseRepository.findAll());
    }

    @Override
    public TDTO findById(ID dtoId) {
        Optional<T> optional = abstractBaseRepository.findById(dtoId);
        return customMapper.mapToDto(optional.orElse(null));
    }

    @Override
    public void delete(TDTO dto) {
        T entity = customMapper.mapToEntity(dto);
        abstractBaseRepository.delete(entity);
    }

    @Override
    public void deleteById(ID dtoId) {
        abstractBaseRepository.deleteById(dtoId);
    }
}
