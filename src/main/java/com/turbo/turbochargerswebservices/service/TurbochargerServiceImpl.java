package com.turbo.turbochargerswebservices.service;

import com.turbo.turbochargerswebservices.model.entity.Turbocharger;
import com.turbo.turbochargerswebservices.repository.TurbochargerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TurbochargerServiceImpl extends AbstractBaseServiceImpl<Turbocharger, Long> implements TurbochargerService{

    private TurbochargerRepository turbochargerRepository;

    @Autowired
    public TurbochargerServiceImpl(TurbochargerRepository turbochargerRepository) {
        super(turbochargerRepository);
    }

    // invoke method everday on 22:16:12
//    @Scheduled(cron = "12 16 22 * * ?")
//    public void createLog(){
//        System.out.println(LocalDateTime.now().toString());
//    }

}
