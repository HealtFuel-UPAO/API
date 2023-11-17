package com.upao.healthfuelapi.Service;

import com.upao.healthfuelapi.model.Habit;
import com.upao.healthfuelapi.model.Routine;

import java.util.List;

public interface HabitService {

    Habit addHabit(Habit habit);
    void deleteHabit(Long id);

    List<Habit> findAllByRoutine(Routine routine);
}