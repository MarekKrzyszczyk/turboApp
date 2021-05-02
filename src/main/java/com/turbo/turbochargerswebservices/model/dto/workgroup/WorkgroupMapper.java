package com.turbo.turbochargerswebservices.model.dto.workgroup;

import com.turbo.turbochargerswebservices.model.dto.CustomMapper;
import com.turbo.turbochargerswebservices.model.dto.Utils;
import com.turbo.turbochargerswebservices.model.entity.Workgroup;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(uses = {Utils.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
public interface WorkgroupMapper extends CustomMapper<Workgroup, WorkgroupDto> {

}
