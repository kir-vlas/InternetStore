package com.drakezzz.internetstore.entity;

import lombok.Data;
import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;

@Data
public class CartLine {

    public CartLine(){
        this.quantity = NumberUtils.LONG_ZERO;
    }

    private Good good;

    private Long quantity;

    public BigDecimal getAmount(){
        return this.good.getPrice().multiply(BigDecimal.valueOf(this.quantity));
    }
}