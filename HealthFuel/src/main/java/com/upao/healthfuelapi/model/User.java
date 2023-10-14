package com.upao.healthfuelapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data //Metodos getters, setters, to string, equals
@Entity //Se vuelva entidad
@Table(name = "users")
@AllArgsConstructor //Constructor con todos los atributos
@NoArgsConstructor //Constructor sin atributos
public class User {
    @Id //Detallar primary keu de la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Se genere el id y tenga autoincremento
    //nullabel(si puede ser nulo), length(longitud), unique(no se puede repetir)
    private long id;
    @Column (nullable = false, length = 50)
    private String first_name;
    @Column (nullable = false, length = 50)
    private  String last_name;
    @Column (nullable = false)
    private LocalDate Birth_date;
    @Column (nullable = false, length = 50, unique = true)
    private String user_name;
    @Column (nullable = false)
    private int gender;
    @Column (nullable = true, length = 200)
    private String description;
    @Column (nullable = false, length = 50, unique = true)
    private String email;
    @Column (nullable = false, length = 50)
    private String password;
    @Column (nullable = false)
    private int rol;
}
