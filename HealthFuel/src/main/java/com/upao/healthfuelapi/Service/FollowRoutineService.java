package com.upao.healthfuelapi.Service;

import com.upao.healthfuelapi.model.Followroutine;
import com.upao.healthfuelapi.model.Routine;
import com.upao.healthfuelapi.model.User;

import java.util.List;

public interface FollowRoutineService {

    List<Routine> getRoutineByUser(User user);
    Followroutine addFollowRoutine(Followroutine followroutine);

    List<Followroutine> getAllFollowRoutines();

}

