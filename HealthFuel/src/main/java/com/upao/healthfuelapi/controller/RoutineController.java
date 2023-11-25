package com.upao.healthfuelapi.controller;

import com.upao.healthfuelapi.Service.RoutineService;
import com.upao.healthfuelapi.model.Routine;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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

    @GetMapping
    public ResponseEntity<List<Routine>> listarRutinas() {
        return ResponseEntity.ok(routineService.findAllRoutine());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarRutina(@PathVariable Long id) {
        this.routineService.deleteRuotine(id);
        return ResponseEntity.ok("Eliminando -> "+id);
    }

    @PutMapping("/update")
    public ResponseEntity<Routine> modificarRutina(@RequestBody Routine routine) {
        Routine modify = routineService.searchById(routine.getId());
        if(modify != null)
            return ResponseEntity.ok(routineService.updateRoutine(routine));
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
