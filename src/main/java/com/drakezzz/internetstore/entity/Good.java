package com.drakezzz.internetstore.entity;

import com.drakezzz.internetstore.api.dto.GoodDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Good {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "CATEGORY")
    private GoodCategory category;

    private String description;

    @Lob
    private byte[] image;

    @Transient
    private CommonsMultipartFile imgFile;

    public static Good of(GoodDto goodDto) {
        Good good = new Good();
        good.setTitle(goodDto.getTitle());
        good.setDescription(goodDto.getDescription());
        good.setCategory(GoodCategory.of(goodDto.getCategory()));
        good.setTitle(goodDto.getTitle());
        good.setTitle(goodDto.getTitle());
        good.setTitle(goodDto.getTitle());
        return good;
    }

}
