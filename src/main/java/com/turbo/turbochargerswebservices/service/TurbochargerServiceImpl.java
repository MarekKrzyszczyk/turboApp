package com.turbo.turbochargerswebservices.service;

import com.turbo.turbochargerswebservices.model.entity.Turbocharger;
import com.turbo.turbochargerswebservices.repository.TurbochargerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurbochargerServiceImpl extends AbstractBaseServiceImpl<Turbocharger, Long> implements TurbochargerService {

    private TurbochargerRepository turbochargerRepository;

    @Autowired
    public TurbochargerServiceImpl(TurbochargerRepository turbochargerRepository) {
        super(turbochargerRepository);
        this.turbochargerRepository = turbochargerRepository;
    }

    // invoke method everday on 22:16:12
//    @Scheduled(cron = "12 16 22 * * ?")
//    public void createLog(){
//        System.out.println(LocalDateTime.now().toString());
//    }

    @Override
    public List<Turbocharger> findByNumber(String number) {
        return turbochargerRepository.findByNumber(number);
    }

    @Override
    public ResponseEntity<Turbocharger> create(Turbocharger turbo) {
        List<Turbocharger> foundTurbos = findByNumber(turbo.getNumber());

        if (foundTurbos.isEmpty()) {
            Turbocharger createdTurbo = turbochargerRepository.save(turbo);
            return new ResponseEntity<>(createdTurbo, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.FOUND);
    }

}
