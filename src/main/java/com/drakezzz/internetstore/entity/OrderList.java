package com.drakezzz.internetstore.entity;

import lombok.Data;

import java.util.List;

@Data
public class OrderList {

    private Order order;

    private List<OrderLine> orderLines;

}
