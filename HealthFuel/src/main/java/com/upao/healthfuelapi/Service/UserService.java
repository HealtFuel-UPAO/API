package com.upao.healthfuelapi.Service;

import com.upao.healthfuelapi.model.User;

import java.util.List;

public interface UserService {
    //Metodos a Implementar

    //Método para registrar un usuario
    public User addUser (User user) throws Exception;

    //Método para autentificar
    public User authUser(String username, String password);

    public List<User> getAllUsers();

    String login(String username, String password);

}

