package com.turbo.turbochargerswebservices.repository;

import com.turbo.turbochargerswebservices.model.Turbocharger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurbochargerRepository extends JpaRepository<Turbocharger, Long> {


}
