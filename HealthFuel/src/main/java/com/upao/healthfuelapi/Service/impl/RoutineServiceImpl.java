package com.upao.healthfuelapi.Service.impl;

import com.upao.healthfuelapi.Service.RoutineService;
import com.upao.healthfuelapi.model.Routine;
import com.upao.healthfuelapi.repository.HabitRepository;
import com.upao.healthfuelapi.repository.RoutineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoutineServiceImpl implements RoutineService {

    private final RoutineRepository routineRepository;
    private final HabitRepository habitRepository;

    public RoutineServiceImpl(RoutineRepository routineRepository, HabitRepository habitRepository) {
        this.routineRepository = routineRepository;
        this.habitRepository = habitRepository;
    }

    @Override
    public Routine addRoutine(Routine routine) {
        return routineRepository.save(routine);
    }

    @Override
    public List<Routine> findAllRoutine() {
        return routineRepository.findAll();
    }

    @Override
    public void deleteRuotine(Long id) {
        this.routineRepository.findAll().stream().filter(r -> r.getId().equals(id)).forEach(e -> {
            e.getListaHabitos().forEach(h -> {
                habitRepository.deleteById(h.getId());
            });
        });
        this.routineRepository.deleteById(id);
    }

}
