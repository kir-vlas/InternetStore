package org.nc.edu.internet_store.mvc.domain;

import javax.persistence.*;

@Entity
@Table(name = "orderlist")
public class OrderList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    public int getId(){return id;}
    public void setId(int id) {
        this.id = id;
    }


    @Column(name = "ORDER")
    private int order;
    public int getOrder(){return order;}
    public void setOrder(int order){
        this.order = order;
    }






}
