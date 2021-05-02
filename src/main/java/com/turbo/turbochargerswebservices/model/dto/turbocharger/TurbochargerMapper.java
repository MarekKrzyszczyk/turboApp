package com.turbo.turbochargerswebservices.model.dto.turbocharger;

import com.turbo.turbochargerswebservices.model.dto.CustomMapper;
import com.turbo.turbochargerswebservices.model.dto.Utils;
import com.turbo.turbochargerswebservices.model.entity.Turbocharger;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(uses = {Utils.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
public interface TurbochargerMapper extends CustomMapper<Turbocharger, TurbochargerDto> {

}
