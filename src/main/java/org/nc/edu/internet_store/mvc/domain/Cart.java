package org.nc.edu.internet_store.mvc.domain;

import java.util.List;
import java.util.ArrayList;

public class Cart {
    private int orderNum;

    private AuthorizedClient client;

    private final List<CartLine> goodsList = new ArrayList<>();

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public AuthorizedClient getClient() {
        return client;
    }

    public void setClient(AuthorizedClient client) {
        this.client = client;
    }

    public List<CartLine> getGoodsList() {
        return goodsList;
    }

    private CartLine findLineById(Integer id){
        for (CartLine line:this.goodsList){
            if (line.getGood().getId() == id){
                return line;
            }
        }
        return null;
    }

    public void AddItem(Good good, Integer quantity){
        CartLine line = this.findLineById(good.getId());
        if(line == null){
            line = new CartLine();
            line.setGood(good);
            this.goodsList.add(line);
        }
        int newQuantity = line.getQuantity()+quantity;
        if (newQuantity <= 0) this.goodsList.remove(line);
        else line.setQuantity(newQuantity);
    }

    public double getAmountTotal(){
        double total = 0;
        for (CartLine line:this.goodsList){
            total += line.getAmount();
        }
        return total;
    }

    public void updateGood(Integer id, int quantity){
        CartLine line = this.findLineById(id);
        if (line != null){
            if (quantity <= 0)
                this.goodsList.remove(line);
        }
        else
            line.setQuantity(quantity);
    }

    public void removeGood(Integer id){
        CartLine line = this.findLineById(id);
        if (line != null)
            this.goodsList.remove(line);
    }
}

class CartLine {

    private Good good;
    private int quantity;

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public CartLine(){
        this.quantity = 0;
    }

    public double getAmount(){
        return this.good.getPrice() * this.quantity;
    }
}