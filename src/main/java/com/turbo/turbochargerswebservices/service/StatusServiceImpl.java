package com.turbo.turbochargerswebservices.service;

import com.turbo.turbochargerswebservices.model.dto.status.StatusDto;
import com.turbo.turbochargerswebservices.model.dto.status.StatusMapper;
import com.turbo.turbochargerswebservices.model.entity.Status;
import com.turbo.turbochargerswebservices.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusServiceImpl extends AbstractBaseServiceImpl<Status, StatusDto, Long> implements StatusService {

    @Autowired
    public StatusServiceImpl(StatusRepository statusRepository, StatusMapper statusMapper) {
        super(statusRepository, statusMapper);
    }
}
