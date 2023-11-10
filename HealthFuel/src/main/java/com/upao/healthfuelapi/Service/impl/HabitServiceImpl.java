package com.upao.healthfuelapi.Service.impl;

import com.upao.healthfuelapi.Service.HabitService;
import com.upao.healthfuelapi.model.Habit;
import com.upao.healthfuelapi.model.Routine;
import com.upao.healthfuelapi.repository.HabitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitServiceImpl implements HabitService {

    private final HabitRepository habitRepository;

    public HabitServiceImpl(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
    }

    @Override
    public Habit addHabit(Habit habit) {
        return habitRepository.save(habit);
    }

    @Override
    public void deleteHabit(Long id) {
        this.habitRepository.deleteById(id);
    }

}