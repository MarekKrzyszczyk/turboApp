package com.turbo.turbochargerswebservices.model.dto.part;

import com.turbo.turbochargerswebservices.model.dto.CustomMapper;
import com.turbo.turbochargerswebservices.model.dto.Utils;
import com.turbo.turbochargerswebservices.model.entity.Part;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(uses = {Utils.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
public interface PartMapper extends CustomMapper<Part, PartDto> {

}
