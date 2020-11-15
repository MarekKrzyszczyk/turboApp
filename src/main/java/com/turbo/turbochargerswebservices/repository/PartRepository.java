package com.turbo.turbochargerswebservices.repository;

import com.turbo.turbochargerswebservices.model.Part;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends AbstractBaseRepository<Part, Long> {
}
