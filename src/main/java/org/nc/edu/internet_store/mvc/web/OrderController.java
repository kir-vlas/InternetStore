package org.nc.edu.internet_store.mvc.web;

import org.nc.edu.internet_store.mvc.domain.Account;
import org.nc.edu.internet_store.mvc.domain.Cart;
import org.nc.edu.internet_store.mvc.domain.CartLine;
import org.nc.edu.internet_store.mvc.service.AccountService;
import org.nc.edu.internet_store.mvc.service.ApplicationMailer;
import org.nc.edu.internet_store.mvc.service.OrderService;
import org.nc.edu.internet_store.mvc.exception.OrderConfirmationException;
import org.nc.edu.internet_store.mvc.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    AccountService accountService;

    @Autowired
    ApplicationMailer mailer;

    @RequestMapping("/order")
    public String order(HttpServletRequest request, Map<String, Object> map){
        Cart cart = Utils.getCartInSession(request);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = null;
        if ((auth instanceof AnonymousAuthenticationToken))
            return "redirect:/cart";
        userDetails = (UserDetails) auth.getPrincipal();
        Account clientAccount = accountService.findAccount(userDetails.getUsername());
        cart.setClient(clientAccount);
        try {
            orderService.saveOrder(cart);
        }
        catch (Exception e){
            throw new OrderConfirmationException(e);
        }
        StringBuilder goodsList  = new StringBuilder();
        for (CartLine cartLine:cart.getGoodsList()) {
            goodsList.append("# " + cartLine.getGood().getId() +"\t" + cartLine.getGood().getTitle() + "\t\t\t\t Quantity: " + cartLine.getQuantity()+'\n');
        }
        mailer.sendMail(clientAccount.getEmail(), "Order №" + cart.getOrderId(),
                "Dear " + clientAccount.getFirstName() +
                        ",\n\n" +
                        "Thank you for your order.  \n" + goodsList.toString() + "\n\n" + cart.getAmountTotal() + " $" +
                        "\n\n\n\nThis email was automatically generated."

                );

        map.put("orderId", cart.getOrderId());
        Utils.removeCartInSession(request);
        return "/viewAfterOrder";
    }
}
