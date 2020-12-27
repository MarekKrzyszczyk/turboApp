package com.turbo.turbochargerswebservices.service;

import com.turbo.turbochargerswebservices.model.entity.Turbocharger;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TurbochargerService extends AbstractBaseService<Turbocharger, Long> {

    List<Turbocharger> findByNumber(String number);

    ResponseEntity<Turbocharger> create(Turbocharger turbo);

}
