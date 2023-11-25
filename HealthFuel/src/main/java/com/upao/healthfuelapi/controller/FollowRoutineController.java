package com.upao.healthfuelapi.controller;

import com.upao.healthfuelapi.Service.FollowRoutineService;
import com.upao.healthfuelapi.model.Followroutine;
import com.upao.healthfuelapi.model.Routine;
import com.upao.healthfuelapi.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("follow")
public class FollowRoutineController {

    private final FollowRoutineService followRoutineService;

    public FollowRoutineController(FollowRoutineService followRoutineService) {
        this.followRoutineService = followRoutineService;
    }


    @GetMapping("/{user}")
    public ResponseEntity<List<Routine>> listarRutinasDeUsuario(@PathVariable User user){
        List<Routine> rutinas =  followRoutineService.getRoutineByUser(user);
        if(rutinas != null)
            return new ResponseEntity<>(rutinas, HttpStatus.CREATED);
        return null;
    }

    @PostMapping
    public ResponseEntity<Followroutine> seguirRutina(@RequestBody Followroutine followroutine){
        System.out.println(followroutine);
        return new ResponseEntity<>(followRoutineService.addFollowRoutine(followroutine), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Followroutine>> listarSeguimientoRutinas(){
        return ResponseEntity.ok(followRoutineService.getAllFollowRoutines());
    }
}
