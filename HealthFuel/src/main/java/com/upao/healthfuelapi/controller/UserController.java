package com.upao.healthfuelapi.controller;

import com.upao.healthfuelapi.Service.UserService;
import com.upao.healthfuelapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
