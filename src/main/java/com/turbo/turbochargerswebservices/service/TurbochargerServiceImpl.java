package com.turbo.turbochargerswebservices.service;

import com.turbo.turbochargerswebservices.model.dto.turbocharger.TurbochargerDto;
import com.turbo.turbochargerswebservices.model.dto.turbocharger.TurbochargerMapper;
import com.turbo.turbochargerswebservices.model.entity.Turbocharger;
import com.turbo.turbochargerswebservices.repository.TurbochargerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurbochargerServiceImpl extends AbstractBaseServiceImpl<Turbocharger, TurbochargerDto, Long>
        implements TurbochargerService {

    private final TurbochargerRepository turbochargerRepository;
    private final TurbochargerMapper turbochargerMapper;

    @Autowired
    public TurbochargerServiceImpl(TurbochargerRepository turbochargerRepository, TurbochargerMapper turbochargerMapper) {
        super(turbochargerRepository, turbochargerMapper);
        this.turbochargerRepository = turbochargerRepository;
        this.turbochargerMapper = turbochargerMapper;
    }

    // invoke method everday on 22:16:12
//    @Scheduled(cron = "12 16 22 * * ?")
//    public void createLog(){
//        System.out.println(LocalDateTime.now().toString());
//    }

    @Override
    public List<TurbochargerDto> findByNumber(String number) {
        List<Turbocharger> turbochargers = turbochargerRepository.findByNumber(number);
        return turbochargerMapper.mapToDtoList(turbochargers);
    }

    @Override
    public TurbochargerDto create(TurbochargerDto turbochargerDto) {
        List<TurbochargerDto> foundTurbos = findByNumber(turbochargerDto.getNumber());

        if (foundTurbos.isEmpty()) {
            Turbocharger turbocharger = turbochargerMapper.mapToEntity(turbochargerDto);
            Turbocharger createdTurbo = turbochargerRepository.save(turbocharger);
            return turbochargerMapper.mapToDto(createdTurbo);
        }

        return null;
    }
}
