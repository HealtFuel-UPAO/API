package com.upao.healthfuelapi.security;

import com.upao.healthfuelapi.model.User;
import com.upao.healthfuelapi.repository.UserRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Slf4j
@Service
public class CustomerDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Getter
    private User userDetails;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Dentro de username");
        userDetails = userRepository.findByUserName(username);

        if(!Objects.isNull(userDetails))
            return new org.springframework.security.core.userdetails.User(userDetails.getUserName(),userDetails.getPassword(), new ArrayList<>());
        else
            throw new UsernameNotFoundException("Usuario no encontrado");
    }


}
