package com.upao.healthfuelapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "routines")
public class Routine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 50, unique = true)
    private String name;
    @Column(length = 500)
    private String description;
    @Column(length = 2)
    private int isPublish;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;


}