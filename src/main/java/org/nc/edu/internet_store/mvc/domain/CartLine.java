package org.nc.edu.internet_store.mvc.domain;


public class CartLine {

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