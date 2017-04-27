package org.nc.edu.internet_store.mvc.domain;

import java.util.List;
import java.util.ArrayList;

public class Cart {
    private List<CartLine> goodsList = new ArrayList<>();

    private Client client;

    class CartLine{
        private Good good;
        private int quantity;
    }
}