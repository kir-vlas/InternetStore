package org.nc.edu.internet_store.mvc.web;

import org.nc.edu.internet_store.mvc.domain.Account;
import org.nc.edu.internet_store.mvc.domain.Cart;
import org.nc.edu.internet_store.mvc.service.AccountService;
import org.nc.edu.internet_store.mvc.service.OrderService;
import org.nc.edu.internet_store.mvc.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    AccountService accountService;

    @RequestMapping("/order")
    public String order(HttpServletRequest request){
        Cart cart = Utils.getCartInSession(request);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = null;
        if ((auth instanceof AnonymousAuthenticationToken))
            return "redirect:/cart";
        userDetails = (UserDetails) auth.getPrincipal();
        Account account = accountService.findAccount(userDetails.getUsername());
        orderService.saveOrder(cart,account);
        return "/viewAfterOrder";
    }
}
