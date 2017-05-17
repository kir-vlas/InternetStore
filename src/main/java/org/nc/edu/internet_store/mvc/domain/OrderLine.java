package org.nc.edu.internet_store.mvc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ORDERLINES")
public class OrderLine {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;

    public Integer getId(){
        return id;
    }


    @Column(name = "ORDER")
    private int order;

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getGood() {
        return good;
    }

    public void setGood(int good) {
        this.good = good;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Column(name = "GOOD")
    private int good;

    @Column(name = "QUANTITY")
    private Integer quantity;

    public Integer getQuantity(){
        return quantity;
    }

}
