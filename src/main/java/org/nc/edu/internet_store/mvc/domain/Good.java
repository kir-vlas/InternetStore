package org.nc.edu.internet_store.mvc.domain;

import com.sun.istack.internal.NotNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

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

    @Transient
    private boolean isValid;
    public boolean isValid() {
        return isValid;
    }
    public void setValid(boolean valid) {
        isValid = valid;
    }

    @Lob
    @Column(name = "IMAGE")
    private byte[] image;
    public byte[] getImage() {
        return image;
    }
    public void setImage(byte[] image) {
        this.image = image;
    }

    @Transient
    private CommonsMultipartFile imgFile;
    public CommonsMultipartFile getImgFile() {
        return imgFile;
    }
    public void setImgFile(CommonsMultipartFile imgFile) {
        this.imgFile = imgFile;
    }
}
