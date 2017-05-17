package org.nc.edu.internet_store.mvc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_LIST")
public class OrderList {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;
    public int getId(){return id;}

    @Column(name = "ORDER")
    private int order;
    public int getOrder(){return order;}
    public void setOrder(int order){
        this.order = order;
    }
}
