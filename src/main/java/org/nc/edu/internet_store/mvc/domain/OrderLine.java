package org.nc.edu.internet_store.mvc.domain;

import com.sun.org.apache.xpath.internal.operations.Or;

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

    @ManyToOne
    @JoinColumn(name = "GOOD")
    private Good good;
    public Good getGood() {
        return good;
    }
    public void setGood(Good good) {
        this.good = good;
    }

    @Column(name = "QUANTITY")
    private Integer quantity;
    public Integer getQuantity(){
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @ManyToOne
    @JoinColumn(name = "ORDERID")
    private Order order;
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
}
