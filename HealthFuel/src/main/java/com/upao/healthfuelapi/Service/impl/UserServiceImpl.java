package com.upao.healthfuelapi.Service.impl;

import com.upao.healthfuelapi.Service.UserService;
import com.upao.healthfuelapi.model.User;
import com.upao.healthfuelapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service  //Lógica de negocios
public class UserServiceImpl implements UserService{
    //Inyección de dependencias
    @Autowired
    private UserRepository userRepository;

    //Registrar un usuario
    @Override
    public User addUser(User user) throws Exception {
        User usuario = userRepository.save(user);
        return usuario;
    }
}
