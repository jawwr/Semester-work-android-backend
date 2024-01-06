package com.example.semester.services;

import com.example.semester.controllers.entities.GetDishDto;
import com.example.semester.entities.Dish;
import com.example.semester.repositories.DishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DishService {
    private final DishRepository repository;

    public List<GetDishDto> getDishList() {
        return repository.findAll().stream().map(GetDishDto::fromEntity).toList();
    }

    public GetDishDto getDishById(int id) {
        return GetDishDto.fromEntity(repository.findById(id).get());
    }

    @Transactional
    public boolean createDish(Dish dish) {
        repository.save(dish);
        return true;
    }
}
