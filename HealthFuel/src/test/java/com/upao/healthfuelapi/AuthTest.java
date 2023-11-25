package com.upao.healthfuelapi;

import com.upao.healthfuelapi.model.User;
import com.upao.healthfuelapi.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AuthTest {

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testLoginSuccess() {

        // Usuario de prueba
        User user = new User(1L, "Hans", "Arnaooooo", LocalDate.now(), "James", 1, "Hola soy hans", "hans@gmail.com", "h123", 1);

        // Configurar el comportamiento del repositorio de autenticación
        when(userRepository.findByUserNameAndPassword("James", "h123")).thenReturn(user);
        // Intentar iniciar sesión
        User userTest = userRepository.findByUserNameAndPassword("James", "h123");
        // Verificar que el usuario devuelto no es nulo
        assertThat(userTest).isNotNull();
    }

    @Test
    void testLoginFailed() {
        // Usuario de prueba
        User user = new User(1L, "Hans", "Arnao", LocalDate.now(), "James", 1, "Hola soy hans", "hans@gmail.com", "h123", 1);

        // Configurar el comportamiento del servicio de autenticación
        when(userRepository.findByUserNameAndPassword("James", "h123")).thenReturn(user);
        // Intentar iniciar sesión
        User userTest = userRepository.findByUserNameAndPassword("Jamemes", "h12323");
        // Verificar que el usuario devuelto no es nulo
        assertThat(userTest).isNull();
    }


}
