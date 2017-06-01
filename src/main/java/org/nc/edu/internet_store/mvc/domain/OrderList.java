package org.nc.edu.internet_store.mvc.domain;

import javax.persistence.*;
import java.util.List;


public class OrderList {

    private Order order;
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }


    private List<OrderLine> orderLines;
    public List<OrderLine> getOrderLines() {
        return orderLines;
    }
    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

}
