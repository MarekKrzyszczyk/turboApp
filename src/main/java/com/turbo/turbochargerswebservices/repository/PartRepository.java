package com.turbo.turbochargerswebservices.repository;

import com.turbo.turbochargerswebservices.model.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends JpaRepository<Part, Integer> {
}
