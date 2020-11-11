package com.turbo.turbochargerswebservices.repository;

import com.turbo.turbochargerswebservices.model.Reason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReasonRepository extends JpaRepository<Reason, Long> {
}
