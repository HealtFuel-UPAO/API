package com.upao.healthfuelapi.controller;

import com.upao.healthfuelapi.Service.UserService;
import com.upao.healthfuelapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UserController {
    //Se llama a los servicios
    @Autowired
    private UserService userService;

    //Registrar usuario
    @PostMapping
    public ResponseEntity<User> registrarUser(@RequestBody User user) throws Exception{
        System.out.println(user);
        return ResponseEntity.ok(userService.addUser(user));
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
}
