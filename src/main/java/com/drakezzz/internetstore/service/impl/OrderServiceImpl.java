package com.drakezzz.internetstore.service.impl;

import com.drakezzz.internetstore.api.dto.OrderDto;
import com.drakezzz.internetstore.entity.Account;
import com.drakezzz.internetstore.entity.Cart;
import com.drakezzz.internetstore.entity.Order;
import com.drakezzz.internetstore.repository.AccountRepository;
import com.drakezzz.internetstore.repository.OrderRepository;
import com.drakezzz.internetstore.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final AccountRepository accountRepository;

    @Override
    public void saveOrder(Cart cart) {
        orderRepository.save(null);
    }

    @Override
    public List<OrderDto> listClientOrders(String login) {
        Account account = accountRepository.findByUsername(login);
        return orderRepository.findByClient(account).stream()
                .map(OrderDto::of)
                .collect(Collectors.toList());
    }

    @Override
    public void changeStatus(Long id, Integer statusCode) {
        Order order = orderRepository
                .findById(id)
                .orElseThrow(NoSuchElementException::new);
        order.setStatus(statusCode.longValue());
        orderRepository.save(order);
    }

    @Override
    public List<OrderDto> listOrders() {
        return orderRepository.findAll()
                .stream()
                .map(OrderDto::of)
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> listOrderLines(Integer id) {
        return orderRepository.findAll();
    }
}
