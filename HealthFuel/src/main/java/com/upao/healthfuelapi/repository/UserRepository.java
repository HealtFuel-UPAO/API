package com.upao.healthfuelapi.repository;

import com.upao.healthfuelapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    //Encontrar un usuario por su nombre y contraseña
    User findByUserNameAndPassword(String username, String password);

    User findByUserName(String username);
}
