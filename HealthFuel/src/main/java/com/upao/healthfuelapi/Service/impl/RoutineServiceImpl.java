package com.upao.healthfuelapi.Service.impl;

import com.upao.healthfuelapi.Service.RoutineService;
import com.upao.healthfuelapi.model.Routine;
import com.upao.healthfuelapi.repository.RoutineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoutineServiceImpl implements RoutineService {

    private final RoutineRepository routineRepository;

    public RoutineServiceImpl(RoutineRepository routineRepository) {
        this.routineRepository = routineRepository;
    }
    @Override
    public Routine addRoutine(Routine routine) {
        return routineRepository.save(routine);
    }

    @Override
    public List<Routine> findAllRoutine() {
        return routineRepository.findAll();
    }

}
