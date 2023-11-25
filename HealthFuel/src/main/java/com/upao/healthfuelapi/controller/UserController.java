package com.upao.healthfuelapi.controller;

import com.upao.healthfuelapi.Service.UserService;
import com.upao.healthfuelapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRange;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/usuarios")
public class UserController {
    //Se llama a los servicios
    @Autowired
    private UserService userService;

    //Registrar usuario
    @PostMapping
    public ResponseEntity<User> registrarUser(@RequestBody User user) throws Exception{
        System.out.println(user);
        if(user.getBirthDate()!= null && fechaValida(user.getBirthDate())){
            if(user.getGender()==1 || user.getGender()==0){
                return ResponseEntity.ok(userService.addUser(user));
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    private boolean fechaValida(LocalDate fechaRecibida){
        LocalDate fechaActual = LocalDate.now();
        return !fechaRecibida.isAfter(fechaActual)&&!fechaRecibida.isEqual(fechaActual);
    }

    //Iniciar Sesión
    @PostMapping("/auth")
    public ResponseEntity<User> autenticarUsuario(@RequestBody User user){
        User us = userService.authUser(user.getUserName(), user.getPassword());
        return ResponseEntity.ok(us);
    }

    @GetMapping
    public ResponseEntity<List<User>> listarUsuarios(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PutMapping("/update")
    public ResponseEntity<User> modificarUsuario(@RequestBody User user) {
        System.out.println(user);
         User modify = userService.searchUserId(user.getId());
        if (modify != null)
            return ResponseEntity.ok(userService.updateUser(user));
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Long id){
        User delete = userService.searchUserId(id);
        if(delete != null){
            userService.deleteUser(id);
            return ResponseEntity.ok("Delete -> "+delete.getUserName());
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/search/{id}")
    public ResponseEntity<User> buscarById(@PathVariable Long id) {
        User searchUser = userService.searchUserId(id);
        if (searchUser != null)
            return ResponseEntity.ok(searchUser);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
