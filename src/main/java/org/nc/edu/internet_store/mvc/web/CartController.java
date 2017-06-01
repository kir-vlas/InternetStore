package org.nc.edu.internet_store.mvc.web;

import org.nc.edu.internet_store.mvc.domain.Cart;
import org.nc.edu.internet_store.mvc.domain.Good;

import org.nc.edu.internet_store.mvc.service.GoodService;
import org.nc.edu.internet_store.mvc.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CartController {

    @Autowired
    private GoodService goodService;

    @RequestMapping(value = { "/cart" }, method = RequestMethod.GET)
    public String shoppingCartHandler(HttpServletRequest request, Model model) {
        Cart myCart = Utils.getCartInSession(request);

        model.addAttribute("cartForm", myCart);
        return "/viewCart";
    }

    @RequestMapping(value = { "/cart" }, method = RequestMethod.POST)
    public String shoppingCartUpdateQty(HttpServletRequest request, //
                                        Model model, //
                                        @ModelAttribute("cartForm") Cart cartForm) {

        Cart cart = Utils.getCartInSession(request);
        cart.updateQuantity(cartForm);

        return "redirect:/cart";
    }

    @RequestMapping(value = {"/cart/removegood"}, method = RequestMethod.GET)
    public String removeGoodHandler(HttpServletRequest request, @RequestParam(value = "id", defaultValue = "0")  String idStr){
        Integer id = Integer.parseInt(idStr);
        Good good = null;
        if (id != 0){
            good = goodService.listGoodById(id);
        }

        if (good != null){
            Cart cart = Utils.getCartInSession(request);
            cart.removeGood(id);
        }
        return "redirect:/cart";
    }
}
