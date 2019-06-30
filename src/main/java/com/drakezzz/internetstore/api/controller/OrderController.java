package com.drakezzz.internetstore.api.controller;

import com.drakezzz.internetstore.api.dto.OrderDto;
import com.drakezzz.internetstore.api.dto.StatusResult;
import com.drakezzz.internetstore.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/client/{clientName}")
    public List<OrderDto> getClientOrders(@PathVariable String clientName) {
        return orderService.listClientOrders(clientName);
    }

    @PostMapping("/client/{clientName}")
    public StatusResult saveOrder(@PathVariable String clientName) {
        return StatusResult.ok();
    }

    @GetMapping
    public List<OrderDto> getAllOrders() {
        return orderService.listOrders();
    }

    @PutMapping("/{orderId}")
    public StatusResult changeOrder(@RequestBody OrderDto orderDto, @PathVariable Long orderId) {
        return StatusResult.ok();
    }

}
