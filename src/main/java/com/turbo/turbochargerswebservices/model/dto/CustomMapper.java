package com.turbo.turbochargerswebservices.model.dto;

import com.turbo.turbochargerswebservices.model.entity.AbstractBaseEntity;
import org.mapstruct.InheritInverseConfiguration;

import java.util.List;

public interface CustomMapper<T extends AbstractBaseEntity, TDTO extends AbstractBaseDto> {

    TDTO mapToDto(T entity);

    @InheritInverseConfiguration
    T mapToEntity(TDTO dto);

    List<TDTO> mapToDtoList(List<T> entities);

    List<T> mapToEntitiesList(List<TDTO> dtos);

}
