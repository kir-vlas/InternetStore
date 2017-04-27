package org.nc.edu.internet_store.mvc.domain;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERS")
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
    private AuthorizedClient client;
    public String getClient(){
        return client.toString();
    }


    @Column(name = "ORDERLINE")
    private List<OrderLine> goodsList = new ArrayList<>();

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

    @Column(name = "DATE")
    private Date date;
    public String getDate(){
        return date.toString();
    }
}
