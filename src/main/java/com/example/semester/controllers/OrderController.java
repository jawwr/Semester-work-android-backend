package com.example.semester.controllers;

import com.example.semester.controllers.entities.GetOrderDto;
import com.example.semester.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService service;

    @GetMapping("/{id}")
    public ResponseEntity<GetOrderDto> getOrderStatus(@PathVariable("id") int orderId) {
        return ResponseEntity.ok(service.getOrderById(orderId));
    }

    @PostMapping
    public ResponseEntity<GetOrderDto> createOrder(@RequestBody Set<Integer> ids) {
        return ResponseEntity.ok(service.createOrder(ids));
    }
}
