package org.nc.edu.internet_store.mvc.domain;

import javax.persistence.*;


@Entity
@Table(name = "orderlines")
public class OrderLine {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getId(){
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
