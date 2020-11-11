package com.turbo.turbochargerswebservices.service;


import com.turbo.turbochargerswebservices.model.Part;
import com.turbo.turbochargerswebservices.model.Turbocharger;
import com.turbo.turbochargerswebservices.repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartService {

    private PartRepository partRepository;

    @Autowired
    public PartService(PartRepository partRepository) {
        this.partRepository = partRepository;
    }

    public List<Part> getAllParts() {
        return partRepository.findAll();
    }

    public Part addPart(Part part) {
        return partRepository.save(part);
    }

    public void deletePart(Long id) {
        partRepository.deleteById(id);
    }

    public Part findPartById(Long id) {
        Optional<Part> optPart = partRepository.findById(id);
        if (optPart.isPresent()) {
            Part part = optPart.get();
            return part;
        }
        return optPart.orElse(new Part());
    }

}
