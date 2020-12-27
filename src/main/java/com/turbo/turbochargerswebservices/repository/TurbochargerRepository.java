package com.turbo.turbochargerswebservices.repository;

import com.turbo.turbochargerswebservices.model.entity.Turbocharger;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurbochargerRepository extends AbstractBaseRepository<Turbocharger, Long> {

   List<Turbocharger> findByNumber(String number);

}
