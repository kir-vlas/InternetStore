package org.nc.edu.internet_store.mvc.domain;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    public static enum Status{RECEIVED, BUILDING, DISATCHED, DELIVERED}

    private static final String[] statusList = {"Received","Building", "Dispatched", "Delivered"};

    public static String[] getStatusesList(){
        return statusList;
    }

    public String[] getStatusList(){
        return statusList;
    }

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getId(){
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "CLIENT")
    private Account client;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Account getClient(){
        return client;
    }
    public void setClient(Account cl){client = cl;}

    @Column(name = "TOTALPRICE")
    private double totalPrice;
    public double getTotalPrice(){
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Column(name = "STATUS")
    private Integer status;
    public String getStatus(){
        return status.toString();
    }
    public void setStatus(Integer st){status = st;}

    @Column(name = "DATE")
    private Date date;
    public Date getDate(){
        return date;
    }
}
