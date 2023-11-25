package com.upao.healthfuelapi.Service.impl;

import com.upao.healthfuelapi.Service.UserService;
import com.upao.healthfuelapi.model.User;
import com.upao.healthfuelapi.repository.UserRepository;
import com.upao.healthfuelapi.security.CustomerDetailService;
import com.upao.healthfuelapi.security.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  //Lógica de negocios
public class UserServiceImpl implements UserService {
    //Inyección de dependencias
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomerDetailService customerDetailService;

    @Autowired
    private JwtUtil jwtUtil;


    //Registrar un usuario
    @Override
    public User addUser(User user) throws Exception {
        User usuario = userRepository.save(user);
        return usuario;
    }

    //Encontrar usuario por username y contraseña
    @Override
    public User authUser(String username, String password) {
        return userRepository.findByUserNameAndPassword(username, password);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public String login(String username, String password) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
            if(authentication.isAuthenticated()){
                return jwtUtil.generateToken(customerDetailService.getUserDetails().getUserName(), customerDetailService.getUserDetails().getRol());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "{\"mensaje\":\"" + "Credenciales incorrectas" + "\"}";
    }
}