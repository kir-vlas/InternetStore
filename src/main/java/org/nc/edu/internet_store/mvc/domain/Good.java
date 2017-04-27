package org.nc.edu.internet_store.mvc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GOODS")
public class Good {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;

    public Integer getId(){
        return id;
    }


    @Column(name = "Title")
    private String title;

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }


    @Column(name = "PRICE")
    private Integer price;

    public Integer getPrice(){
        return price;
    }

    public void setPrice(Integer price){
        this.price = price;
    }


    @Column(name = "CATEGORY")
    private Category category;
    public Category getCategory(){
        return category;
    }

    public void setCategory(Category category){
        this.category = category;
    }


    @Column(name = "DESCRIPTION")
    private String description;

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

}
