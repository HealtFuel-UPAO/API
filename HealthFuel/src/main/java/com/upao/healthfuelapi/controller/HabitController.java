package com.upao.healthfuelapi.controller;

import com.upao.healthfuelapi.Service.HabitService;
import com.upao.healthfuelapi.model.Habit;
import com.upao.healthfuelapi.model.Routine;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("habitos")
public class HabitController {

    private HabitService habitService;

    public HabitController(HabitService habitService) {
        this.habitService = habitService;
    }

    @PostMapping
    public ResponseEntity<Habit> addHabit(@RequestBody Habit habit){
        return ResponseEntity.ok(habitService.addHabit(habit));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarRutina(@PathVariable Long id){
        this.habitService.deleteHabit(id);
        return ResponseEntity.ok("Eliminando -> "+id);
    }
}
