package org.nc.edu.internet_store.mvc.util;

import javax.servlet.http.HttpServletRequest;
import org.nc.edu.internet_store.mvc.domain.Cart;
import org.nc.edu.internet_store.mvc.domain.Category;
import org.springframework.security.core.userdetails.UserDetails;

public class Utils {

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

    public static void saveCategory(HttpServletRequest request,Category category){
        request.getSession().setAttribute("categoryForSave",category);
    }

    public static Category getSavedCategory(HttpServletRequest request){
        return (Category) request.getSession().getAttribute("categoryForSave");
    }

    public static void storeCurrentUser(HttpServletRequest request, Integer id){
        request.getSession().setAttribute("userId", id);

    }


}
