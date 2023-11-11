package com.upao.healthfuelapi.Service;

import com.upao.healthfuelapi.Service.impl.UserServiceImpl;
import com.upao.healthfuelapi.model.User;
import com.upao.healthfuelapi.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.LocalDate;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private User user;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

        LocalDate local = LocalDate.now();

        user = new User();
        user.setId(1L);
        user.setFirstName("Hans");
        user.setLastName("Arnao");
        user.setBirthDate(local);
        user.setUserName("HansA");
        user.setGender(1);
        user.setDescription("zZzZZ");
        user.setEmail("hans@gmail.com");
        user.setPassword("123");
        user.setRol(2);
    }
    @Test
    void findAll(){
        when(userRepository.findAll()).thenReturn(Collections.singletonList(user));
        assertNotNull(userService.getAllUsers());
    }
    @Test
    void registrarUsuario() throws Exception {
        when(userRepository.save(any(User.class))).thenReturn(user);
        // Llamar al método del servicio que crea el registro
        User result = userService.addUser(user);
        // Verificar que se llamó al método save del repositorio con el registro correcto
        verify(userRepository, times(1)).save(eq(user));
        // Verificar que el resultado no es nulo
        assertNotNull(result);
    }
}
