package com.turbo.turbochargerswebservices.service;

import com.turbo.turbochargerswebservices.model.dto.reason.ReasonDto;
import com.turbo.turbochargerswebservices.model.dto.reason.ReasonMapper;
import com.turbo.turbochargerswebservices.model.entity.Reason;
import com.turbo.turbochargerswebservices.repository.ReasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReasonServiceImpl extends AbstractBaseServiceImpl<Reason, ReasonDto, Long> implements ReasonService{

    @Autowired
    public ReasonServiceImpl(ReasonRepository reasonRepository, ReasonMapper reasonMapper) {
        super(reasonRepository, reasonMapper);
    }
}
