package com.upao.healthfuelapi.repository;

import com.upao.healthfuelapi.model.Habit;
import com.upao.healthfuelapi.model.Routine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabitRepository extends JpaRepository<Habit, Long> {

    List<Habit> findAllByRoutine(Routine routine);

}
