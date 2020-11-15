package com.turbo.turbochargerswebservices.repository;

import com.turbo.turbochargerswebservices.model.Status;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends AbstractBaseRepository<Status, Long> {
}
