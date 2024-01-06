package com.vanderlelie.api.backend.service;

import com.vanderlelie.api.backend.model.Order;
import com.vanderlelie.api.backend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> findOrderById(UUID id) {
        return orderRepository.findById(id);
    }

    public Order saveOrUpdateOrder(Order order) {
        return orderRepository.save(order);
    }

    public boolean deleteOrder(UUID id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Order> updateOrder(UUID id, Order orderDetails) {
        return orderRepository.findById(id)
                .map(order -> {
                    // Update fields of the order here
                    order.setCustomer(orderDetails.getCustomer());
                    order.setUser(orderDetails.getUser());
                    order.setProduct(orderDetails.getProduct());
                    order.setDate(orderDetails.getDate());
                    // ... other fields
                    return orderRepository.save(order);
                });
    }

    // Custom methods
    public List<Order> findOrdersByCustomerId(UUID customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    public List<Order> findOrdersByUserId(UUID userId) {
        return orderRepository.findByUserId(userId);
    }
}
