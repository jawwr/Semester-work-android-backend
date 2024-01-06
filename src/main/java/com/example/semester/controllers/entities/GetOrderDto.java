package com.example.semester.controllers.entities;

import com.example.semester.entities.Order;
import com.example.semester.entities.OrderStatus;

public record GetOrderDto(
        int id,
        OrderStatus status
) {
    public static GetOrderDto fromEntity(Order order) {
        return new GetOrderDto(
                order.getId(),
                order.getStatus()
        );
    }
}
