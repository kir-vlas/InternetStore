package com.drakezzz.internetstore.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class Cart {

    private int orderId;

    private Account client;

    private final List<CartLine> goodsList = new ArrayList<>();

    private CartLine findLineById(Long id){
        for (CartLine line:this.goodsList){
            if (line.getGood().getId().equals(id)){
                return line;
            }
        }
        return null;
    }

    public void AddItem(Good good, Long quantity){
        CartLine line = this.findLineById(good.getId());
        if(line == null){
            line = new CartLine();
            line.setGood(good);
            this.goodsList.add(line);
        }
        long newQuantity = line.getQuantity()+quantity;
        if (newQuantity <= 0) this.goodsList.remove(line);
        else line.setQuantity(newQuantity);
    }

    public BigDecimal getAmountTotal(){
        BigDecimal total = BigDecimal.ZERO;
        for (CartLine line:this.goodsList){
            total = total.add(line.getAmount());
        }
        return total;
    }

    public void updateGood(Long id, Long quantity) {
        CartLine line = this.findLineById(id);
        if (line != null) {
            if (quantity <= 0)
                this.goodsList.remove(line);
        else
            line.setQuantity(quantity);
        }
    }

    public void removeGood(Long id){
        CartLine line = this.findLineById(id);
        if (line != null)
            this.goodsList.remove(line);
    }

    public void updateQuantity(Cart cartForm) {
        if (cartForm != null) {
            List<CartLine> lines = cartForm.getGoodsList();
            for (CartLine line : lines) {
                this.updateGood(line.getGood().getId(), line.getQuantity());
            }
        }

    }
}
