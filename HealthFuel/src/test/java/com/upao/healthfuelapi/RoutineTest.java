package com.upao.healthfuelapi;

import com.upao.healthfuelapi.model.Routine;
import com.upao.healthfuelapi.model.User;
import com.upao.healthfuelapi.repository.RoutineRepository;
import com.upao.healthfuelapi.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class RoutineTest {

    @Mock
    private RoutineRepository routineRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateRoutineSuccess(){
        Routine routine = Routine.builder().id(1L).name("Almuerzo Intensivo").isPublish(1).description("Almuerzos fuertes").build();
        when(routineRepository.save(any(Routine.class))).thenReturn(routine);
    }

    @Test
    void testCreateRoutineEmpty(){
        Routine routine = Routine.builder().id(1L).name(null).isPublish(1).description("Almuerzos fuertes").build();

        //assertThat(routine.getId()).isNull();

        //Este esta vací por eso fallará
        assertThat(routine.getName()).isNotEmpty();

        // assertThat(routine.getIsPublish()).isNegative();

        // assertThat(routine.getDescription()).isNotEmpty();
    }


}
