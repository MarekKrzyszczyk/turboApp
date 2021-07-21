package com.turbo.turbochargerswebservices.service;

import com.turbo.turbochargerswebservices.model.dto.turbocharger.TurbochargerDto;

import java.util.List;

public interface TurbochargerService extends AbstractBaseService<TurbochargerDto, Long> {

    List<TurbochargerDto> findByNumber(String number);

    TurbochargerDto create(TurbochargerDto turbo);
}

