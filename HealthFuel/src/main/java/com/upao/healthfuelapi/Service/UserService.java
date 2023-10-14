package com.upao.healthfuelapi.Service;

import com.upao.healthfuelapi.model.User;

public interface UserService {
    //Metodos a Implementar

    //Método para registrar un usuario
    public User addUser (User user) throws Exception;

    //Método para autentificar
    public User authUser(String username, String password);
}
