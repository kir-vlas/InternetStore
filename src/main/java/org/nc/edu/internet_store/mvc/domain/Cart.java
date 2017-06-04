package org.nc.edu.internet_store.mvc.domain;

import java.util.List;
import java.util.ArrayList;

public class Cart {
    private int orderId;

    private Account client;

    private final List<CartLine> goodsList = new ArrayList<CartLine>();

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Account getClient() {
        return client;
    }

    public void setClient(Account client) {
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

    public void updateGood(Integer id, int quantity) {
        CartLine line = this.findLineById(id);
        if (line != null) {
            if (quantity <= 0)
                this.goodsList.remove(line);
        else
            line.setQuantity(quantity);
        }
    }

    public void removeGood(Integer id){
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
