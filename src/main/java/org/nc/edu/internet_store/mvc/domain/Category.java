package org.nc.edu.internet_store.mvc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "CATEGORIES")
public class Category {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;

    public Integer getId(){
        return id;
    }


    @Column(name = "CATEGORY")
    private String cat;

    public String getCategory(){
        return cat;
    }

    public void setCategory(String name){
        cat = name;
    }
}
