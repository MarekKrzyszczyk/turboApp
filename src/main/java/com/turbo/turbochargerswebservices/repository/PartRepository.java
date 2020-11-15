package com.turbo.turbochargerswebservices.repository;

import com.turbo.turbochargerswebservices.model.entity.Part;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends AbstractBaseRepository<Part, Long> {
}
