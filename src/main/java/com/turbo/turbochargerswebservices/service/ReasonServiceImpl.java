package com.turbo.turbochargerswebservices.service;

import com.turbo.turbochargerswebservices.model.Reason;
import com.turbo.turbochargerswebservices.repository.ReasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReasonServiceImpl extends AbstractBaseServiceImpl<Reason, Long> implements ReasonService{

    private ReasonRepository reasonRepository;

    @Autowired
    public ReasonServiceImpl(ReasonRepository reasonRepository) {
        super(reasonRepository);
    }

}
