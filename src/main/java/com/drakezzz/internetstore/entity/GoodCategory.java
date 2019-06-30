package com.drakezzz.internetstore.entity;

import com.drakezzz.internetstore.api.dto.CategoryDto;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class GoodCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;

    public static GoodCategory of(CategoryDto categoryDto) {
        GoodCategory goodCategory = new GoodCategory();
        goodCategory.setCategory(categoryDto.getCategory());
        return goodCategory;
    }

}
