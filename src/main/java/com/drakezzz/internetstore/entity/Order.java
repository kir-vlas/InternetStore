package com.drakezzz.internetstore.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Account client;

    private Long status;

    @Temporal(TemporalType.DATE)
    private Date orderDate;

    @OneToMany(targetEntity = OrderLine.class, mappedBy = "id", cascade = CascadeType.ALL)
    private Set<OrderLine> orderLines;

}
