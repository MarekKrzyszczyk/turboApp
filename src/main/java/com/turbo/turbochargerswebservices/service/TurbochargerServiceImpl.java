package com.turbo.turbochargerswebservices.service;

import com.turbo.turbochargerswebservices.model.entity.Turbocharger;
import com.turbo.turbochargerswebservices.repository.TurbochargerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurbochargerServiceImpl extends AbstractBaseServiceImpl<Turbocharger, Long> implements TurbochargerService{

    private TurbochargerRepository turbochargerRepository;

    @Autowired
    public TurbochargerServiceImpl(TurbochargerRepository turbochargerRepository) {
        super(turbochargerRepository);
    }

}
