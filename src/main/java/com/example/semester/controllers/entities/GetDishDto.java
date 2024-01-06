package com.example.semester.controllers.entities;

import com.example.semester.entities.Dish;

public record GetDishDto(
        int id,
        String title,
        double price,
        int mass,
        int kcal,
        String description,
        String photoUrl
) {
    public static GetDishDto fromEntity(Dish dish) {
        return new GetDishDto(
                dish.getId(),
                dish.getTitle(),
                dish.getPrice(),
                dish.getMass(),
                dish.getKcal(),
                dish.getDescription(),
                dish.getPhotoUrl()
        );
    }
}
