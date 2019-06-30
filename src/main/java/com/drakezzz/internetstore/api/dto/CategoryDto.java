package com.drakezzz.internetstore.api.dto;

import com.drakezzz.internetstore.entity.GoodCategory;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CategoryDto {

    private Long id;

    @NotBlank
    private String category;

    public static CategoryDto of(GoodCategory goodCategory) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategory(goodCategory.getCategory());
        categoryDto.setId(goodCategory.getId());
        return categoryDto;
    }

}
