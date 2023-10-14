package com.upao.healthfuelapi.repository;

import com.upao.healthfuelapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
