package com.drakezzz.internetstore.util;

import com.drakezzz.internetstore.entity.Cart;
import com.drakezzz.internetstore.entity.GoodCategory;

import javax.servlet.http.HttpServletRequest;

public class CartUtils {

    public static Cart getCartInSession(HttpServletRequest request){
        Cart cart = (Cart) request.getSession().getAttribute("myCart");

        if (cart == null){
            cart = new Cart();
            request.getSession().setAttribute("myCart", cart);
        }
        return cart;
    }

    public static void removeCartInSession(HttpServletRequest request) {
        request.getSession().removeAttribute("myCart");
    }

    public static void storeLastOrderedCartInSession(HttpServletRequest request, Cart cart) {
        request.getSession().setAttribute("lastOrderedCart", cart);
    }

    public static Cart getLastOrderedCartInSession(HttpServletRequest request) {
        return (Cart) request.getSession().getAttribute("lastOrderedCart");
    }

    public static void saveCategory(HttpServletRequest request, GoodCategory category){
        request.getSession().setAttribute("categoryForSave",category);
    }

    public static GoodCategory getSavedCategory(HttpServletRequest request){
        return (GoodCategory) request.getSession().getAttribute("categoryForSave");
    }

    public static void storeCurrentUser(HttpServletRequest request, Integer id){
        request.getSession().setAttribute("userId", id);

    }


}
