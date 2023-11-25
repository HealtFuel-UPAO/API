package com.upao.healthfuelapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data //Metodos getters, setters, to string, equals
@Entity //Se vuelva entidad
@Builder
@Table(name = "users")
@AllArgsConstructor //Constructor con todos los atributos
@NoArgsConstructor //Constructor sin atributos
public class User {
    @Id //Detallar primary keu de la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Se genere el id y tenga autoincremento
    //nullabel(si puede ser nulo), length(longitud), unique(no se puede repetir)
    private Long id;
    @Column (nullable = false, length = 50)
    private String firstName;
    @Column (nullable = false, length = 50)
    private  String lastName;
    @Column (nullable = false)
    private LocalDate birthDate;
    @Column (nullable = false, length = 50, unique = true)
    private String userName;
    @Column (nullable = false)
    private int gender;
    @Column (nullable = true)
    private String description;
    @Column (nullable = false, length = 50, unique = true)
    private String email;
    @Column (nullable = false, length = 50)
    private String password;
    @Column (nullable = false, length = 50)
    private int rol;
}
