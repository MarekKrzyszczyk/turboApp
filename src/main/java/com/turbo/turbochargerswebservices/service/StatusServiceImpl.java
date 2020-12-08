package com.turbo.turbochargerswebservices.service;

import com.turbo.turbochargerswebservices.model.entity.Status;
import com.turbo.turbochargerswebservices.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusServiceImpl extends AbstractBaseServiceImpl<Status, Long> implements StatusService{

    private StatusRepository statusRepository;

    @Autowired
    public StatusServiceImpl(StatusRepository statusRepository) {
        super(statusRepository);
    }

}
