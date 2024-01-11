package com.example.semester.services;

import com.example.semester.controllers.entities.GetOrderDto;
import com.example.semester.entities.Order;
import com.example.semester.entities.OrderStatus;
import com.example.semester.repositories.DishRepository;
import com.example.semester.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository repository;
    private final DishRepository dishRepository;

    @Transactional
    public GetOrderDto getOrderById(int id) {
        Order order = repository.findById(id).get();
        int between = (int) Duration.between(order.getOrderTime(), LocalDateTime.now()).toMinutes() / 2;
        OrderStatus status;
        if (between < 5) {
            status = OrderStatus.values()[between % 5];
        } else {
            status = OrderStatus.DONE;
        }
        order.setStatus(status);
        return GetOrderDto.fromEntity(order);
    }

    @Transactional
    public GetOrderDto createOrder(Set<Integer> dishesId) {
        var dishes = dishRepository.findAllById(dishesId);
        Order order = new Order();
        order.setDishes(dishes);
        order.setOrderTime(LocalDateTime.now());
        order.setStatus(OrderStatus.COLLECTING);
        return GetOrderDto.fromEntity(repository.save(order));
    }
}
