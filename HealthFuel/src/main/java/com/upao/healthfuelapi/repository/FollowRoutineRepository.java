package com.upao.healthfuelapi.repository;

import com.upao.healthfuelapi.model.Followroutine;
import com.upao.healthfuelapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowRoutineRepository extends JpaRepository<Followroutine, Long> {

    List<Followroutine> findByUser(User user);


}
