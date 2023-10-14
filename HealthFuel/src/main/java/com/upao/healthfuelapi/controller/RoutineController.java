package com.upao.healthfuelapi.controller;

import com.upao.healthfuelapi.Service.RoutineService;
import com.upao.healthfuelapi.model.Routine;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rutinas")
public class RoutineController {

    private final RoutineService routineService;

    public RoutineController(RoutineService routineService) {
        this.routineService = routineService;
    }

    @PostMapping
    public ResponseEntity<Routine> registrarRoutine(@RequestBody Routine routine) {
        return (routineService.addRoutine(routine) != null) ? new ResponseEntity<>(routine, HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


}
