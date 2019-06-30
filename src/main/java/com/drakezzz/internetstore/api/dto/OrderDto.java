package com.drakezzz.internetstore.api.dto;

import com.drakezzz.internetstore.entity.Order;
import com.drakezzz.internetstore.entity.OrderLine;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Data
public class OrderDto {

    private Long status;

    private LocalDateTime orderDate;

    private List<OrderLine> orderItems;

    public static OrderDto of(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderDate(order.getOrderDate().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime());
        orderDto.setStatus(order.getStatus());
        return orderDto;
    }

}
