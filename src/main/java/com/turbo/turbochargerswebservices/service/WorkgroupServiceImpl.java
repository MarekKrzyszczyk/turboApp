package com.turbo.turbochargerswebservices.service;

import com.turbo.turbochargerswebservices.model.entity.Workgroup;
import com.turbo.turbochargerswebservices.repository.WorkgroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkgroupServiceImpl extends AbstractBaseServiceImpl<Workgroup, Long> implements WorkgroupService{

    private WorkgroupRepository workgroupRepository;

    @Autowired
    public WorkgroupServiceImpl(WorkgroupRepository workgroupRepository) {
        super(workgroupRepository);
    }

}
