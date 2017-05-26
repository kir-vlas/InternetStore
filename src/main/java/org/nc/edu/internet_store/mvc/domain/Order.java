package org.nc.edu.internet_store.mvc.domain;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    private enum Status{RECEIVED, BUILDING, DISATCHED, DELIVERED}

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;

    public Integer getId(){
        return id;
    }

    @Column(name = "CLIENT")
    private int client;
    public int getClient(){
        return client;
    }
    public void setClient(int cl){client = cl;}

    @ManyToOne
    @JoinColumn(name = "ORDERLINE")
    private OrderLine orderLine;
    public OrderLine getOrderLine(){return orderLine;}
    public void setOrderLine(OrderLine gl){orderLine = gl;}

    @Column(name = "TOTALPRICE")
    private Integer totalPrice;
    public Integer getTotalPrice(){
        return totalPrice;
    }

    @Column(name = "STATUS")
    private Status status;
    public String getStatus(){
        return status.toString();
    }
    public void setStatus(Status st){status = st;}

    @Column(name = "DATE")
    private Date date;
    public String getDate(){
        return date.toString();
    }
}
