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
    private Order order;


    @Column(name = "GOOD")
    private Good good;

    @Column(name = "QUANTITY")
    private Integer quantity;

    public Integer getQuantity(){
        return quantity;
    }

}
