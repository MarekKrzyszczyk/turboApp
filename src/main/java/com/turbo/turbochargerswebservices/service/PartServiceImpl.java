package com.turbo.turbochargerswebservices.service;

import com.turbo.turbochargerswebservices.model.dto.part.PartDto;
import com.turbo.turbochargerswebservices.model.dto.part.PartMapper;
import com.turbo.turbochargerswebservices.model.entity.Part;
import com.turbo.turbochargerswebservices.repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartServiceImpl extends AbstractBaseServiceImpl<Part, PartDto, Long> implements PartService{

    @Autowired
    public PartServiceImpl(PartRepository partRepository, PartMapper partMapper) {
        super(partRepository, partMapper);
    }
}
