package com.upao.healthfuelapi.Service.impl;

import com.upao.healthfuelapi.Service.FollowRoutineService;
import com.upao.healthfuelapi.model.Followroutine;
import com.upao.healthfuelapi.model.Routine;
import com.upao.healthfuelapi.model.User;
import com.upao.healthfuelapi.repository.FollowRoutineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowRoutineServiceImpl implements FollowRoutineService {

    private final FollowRoutineRepository followRoutineRepository;

    public FollowRoutineServiceImpl(FollowRoutineRepository followRoutineRepository) {
        this.followRoutineRepository = followRoutineRepository;
    }

    @Override
    public List<Routine> getRoutineByUser(User user) {
        List<Followroutine> followsUser = this.followRoutineRepository.findByUser(user);
        return followsUser.stream().map(Followroutine::getRoutine).toList();
    }

    @Override
    public Followroutine addFollowRoutine(Followroutine followroutine) {
        return followRoutineRepository.save(followroutine);
    }

    @Override
    public List<Followroutine> getAllFollowRoutines() {
        return followRoutineRepository.findAll();
    }
}