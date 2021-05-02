package com.turbo.turbochargerswebservices.service;

import com.turbo.turbochargerswebservices.model.dto.workgroup.WorkgroupDto;
import com.turbo.turbochargerswebservices.model.dto.workgroup.WorkgroupMapper;
import com.turbo.turbochargerswebservices.model.entity.Workgroup;
import com.turbo.turbochargerswebservices.repository.WorkgroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkgroupServiceImpl extends AbstractBaseServiceImpl<Workgroup, WorkgroupDto, Long> implements WorkgroupService{

    @Autowired
    public WorkgroupServiceImpl(WorkgroupRepository workgroupRepository, WorkgroupMapper workgroupMapper) {
        super(workgroupRepository, workgroupMapper);
    }
}
