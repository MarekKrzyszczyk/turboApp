package com.turbo.turbochargerswebservices.service;

import com.turbo.turbochargerswebservices.model.Reason;
import com.turbo.turbochargerswebservices.repository.ReasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
