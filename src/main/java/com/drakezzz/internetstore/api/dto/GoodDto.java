package com.drakezzz.internetstore.api.dto;

import com.drakezzz.internetstore.entity.Good;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodDto {

    @NotBlank
    private String title;

    @NotNull
    private BigDecimal price;

    @NotBlank
    private CategoryDto category;

    @NotBlank
    private String description;

    private byte[] image;

    public static GoodDto of(Good good) {
        GoodDto goodDto = new GoodDto();
        goodDto.setCategory(CategoryDto.of(good.getCategory()));
        goodDto.setDescription(good.getDescription());
        goodDto.setTitle(good.getTitle());
        goodDto.setPrice(good.getPrice());
        goodDto.setImage(good.getImage());
        return goodDto;
    }

}
