package com.example.semester.controllers;

import com.example.semester.controllers.entities.GetDishDto;
import com.example.semester.entities.Dish;
import com.example.semester.services.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dishes")
@RequiredArgsConstructor
public class DishController {
    private final DishService service;

    @GetMapping
    public ResponseEntity<List<GetDishDto>> getDishes() {
        return ResponseEntity.ok(service.getDishList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetDishDto> getDishById(@PathVariable("id") int id) {
        return ResponseEntity.ok(service.getDishById(id));
    }

    @PostMapping
    public ResponseEntity<Boolean> createDish(@RequestBody Dish dish) {
        return ResponseEntity.ok(service.createDish(dish));
    }
}
