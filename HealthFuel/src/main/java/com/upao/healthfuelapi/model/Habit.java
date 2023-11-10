package com.upao.healthfuelapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name = "habitos")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(exclude = "routine")
public class Habit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50,nullable = false)
    private String name;
    private String initialHour;
    private String frequency;
    private String description;

    @ManyToOne
    @JoinColumn(name = "routine_id")
    private Routine routine;


}
