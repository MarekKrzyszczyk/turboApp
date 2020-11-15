package com.turbo.turbochargerswebservices.service;


import com.turbo.turbochargerswebservices.model.entity.Part;
import com.turbo.turbochargerswebservices.repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartServiceImpl extends AbstractBaseServiceImpl<Part, Long> implements PartService{

    private PartRepository partRepository;

    @Autowired
    public PartServiceImpl(PartRepository partRepository) {
        super(partRepository);
    }

}
