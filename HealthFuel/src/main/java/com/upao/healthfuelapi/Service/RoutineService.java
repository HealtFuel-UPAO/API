package com.upao.healthfuelapi.Service;

import com.upao.healthfuelapi.model.Routine;
import java.util.List;

public interface RoutineService {

    Routine addRoutine(Routine routine);

    List<Routine> findAllRoutine();

}

