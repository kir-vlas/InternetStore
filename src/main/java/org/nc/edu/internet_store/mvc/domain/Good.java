package org.nc.edu.internet_store.mvc.domain;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "goods")
public class Good {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    @NotNull
    @Column(name = "TITLE")
    private String title;
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    @NotNull
    @Column(name = "PRICE")
    private Integer price;
    public Integer getPrice(){
        return price;
    }
    public void setPrice(Integer price){
        this.price = price;
    }


    @ManyToOne
    @JoinColumn(name = "CATEGORY")
    private Category category;
    public Category getCategory(){
        return category;
    }

    public void setCategory(Category category){
        this.category = category;
    }

    @NotNull
    @Column(name = "DESCRIPTION")
    private String description;
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

}
