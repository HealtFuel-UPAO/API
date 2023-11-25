package com.upao.healthfuelapi;

import com.upao.healthfuelapi.model.User;
import com.upao.healthfuelapi.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserTest {

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    //Creación exitosa
    @Test
    void testCreateUserSuccess() {
        when(userRepository.save(any(User.class))).thenReturn(new User(1L, "Hans", "Arnao", LocalDate.now(),"James",1,"Hola soy hans","hans@gmail.com","h123",1));
    }


    //Usuario ya existe
    @Test
    void testCreateUserExist() {
        Long id = 1L;
        User user = new User();

        when(userRepository.findById(id)).thenReturn(Optional.of(user));

        // 2L
        Optional<User> resultUser = userRepository.findById(1L);

        assertTrue(resultUser.isPresent());
        User resp = resultUser.get();
        assertNotNull(resp);
        assertInstanceOf(User.class, resp);
    }

    @Test
    void testCreateUserEmptyField() {
        User user = new User(1L, "Hans", "Arnao", LocalDate.now(),"James",1,"Hola soy hans","hans@gmail.com","h123",1);

        assertThat(user.getId()).isNotNull();
        assertThat(user.getFirstName()).isNotNull();
        assertThat(user.getLastName()).isNotNull();
        assertThat(user.getBirthDate()).isNotNull();
        assertThat(user.getUserName()).isNotNull();
        assertThat(user.getGender()).isNotNull();
        assertThat(user.getEmail()).isNotNull();
        assertThat(user.getPassword()).isNotNull();
        assertThat(user.getRol()).isNotNull();

        // Verificar que ninguno de los atributos sea vacío (en el caso de cadenas)
        assertThat(user.getFirstName()).isNotEmpty();
        assertThat(user.getLastName()).isNotEmpty();
        assertThat(user.getUserName()).isNotEmpty();
        assertThat(user.getEmail()).isNotEmpty();
        assertThat(user.getPassword()).isNotEmpty();
        assertThat(user.getRol()).isNotNegative();
    }

    //Comprueba la existencia de la lista de usuarios
    @Test
    void testViewUsers(){
        List<User> listTest = new ArrayList<>();
        when(userRepository.findAll()).thenReturn(listTest);
        List<User> result = userRepository.findAll();
        assertNotNull(result);
    }

    //Comprueba que la lista contiene usuarios
    @Test
    void testViewUsersIsEmpty(){
        List<User> listTest = new ArrayList<>();
        when(userRepository.findAll()).thenReturn(listTest);
        List<User> result = userRepository.findAll();
        assertTrue(result.isEmpty());
    }

}