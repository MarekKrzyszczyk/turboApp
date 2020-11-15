package com.turbo.turbochargerswebservices.service;

import com.turbo.turbochargerswebservices.model.Turbocharger;
import com.turbo.turbochargerswebservices.repository.TurbochargerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurbochargerService {

    private TurbochargerRepository turbochargerRepository;

    @Autowired
    public TurbochargerService(TurbochargerRepository turbochargerRepository) {
        this.turbochargerRepository = turbochargerRepository;
    }

    public List<Turbocharger> getAllTurbos() {
        return turbochargerRepository.findAll();
    }

    public Turbocharger addTurbo(Turbocharger turbocharger) {
        return turbochargerRepository.save(turbocharger);
    }

    public void deleteTurbo(Long id) {
        turbochargerRepository.deleteById(id);
    }

    public Turbocharger findTurboById(Long id) {
        Optional<Turbocharger> optTurbo = turbochargerRepository.findById(id);
        if (optTurbo.isPresent()) {
            Turbocharger turbo = optTurbo.get();
            return turbo;
        }
        return optTurbo.orElse(new Turbocharger());
    }

}
