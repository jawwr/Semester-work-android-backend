package com.example.semester.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "dishes")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "mass", nullable = false)
    private int mass;

    @Column(name = "kcal", nullable = false)
    private int kcal;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "photoUrl", nullable = false)
    private String photoUrl;
}
