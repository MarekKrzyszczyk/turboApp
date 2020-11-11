package com.turbo.turbochargerswebservices.service;

import com.turbo.turbochargerswebservices.model.Reason;
import com.turbo.turbochargerswebservices.repository.ReasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReasonService {

    private ReasonRepository reasonRepository;

    @Autowired
    public ReasonService(ReasonRepository reasonRepository) {
        this.reasonRepository = reasonRepository;
    }

    public List<Reason> getAllReasons() {
        return reasonRepository.findAll();
    }

    public Reason addReason(Reason reason) {
        return reasonRepository.save(reason);
    }

    public void deleteReason(Long id) {
        reasonRepository.deleteById(id);
    }

    public Reason findReasonById(Long id) {
        Optional<Reason> optReason = reasonRepository.findById(id);
        if (optReason.isPresent()) {
            Reason reason = optReason.get();
            return reason;
        }
        return optReason.orElse(new Reason());
    }

}
