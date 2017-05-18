package org.nc.edu.internet_store.mvc.domain;

import javax.persistence.*;


@Entity
@Table(name = "CATEGORIES")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    public Integer getId(){
        return id;
    }
    public void setId(Integer id){this.id = id;}

    @Column(name = "CATEGORY")
    private String category;

    public String getCategory(){
        return category;
    }

    public void setCategory(String category){
        this.category = category;
    }
}
