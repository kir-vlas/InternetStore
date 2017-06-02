package org.nc.edu.internet_store.mvc.web;

import org.nc.edu.internet_store.mvc.domain.Account;
import org.nc.edu.internet_store.mvc.domain.Order;
import org.nc.edu.internet_store.mvc.domain.OrderList;
import org.nc.edu.internet_store.mvc.service.AccountService;
import org.nc.edu.internet_store.mvc.service.OrderService;
import org.nc.edu.internet_store.mvc.service.RegistrationService;
import org.nc.edu.internet_store.mvc.validator.ClientValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class ClientController {

    @Autowired
    RegistrationService registrationService;

    @Autowired
    OrderService orderService;

    @Autowired
    AccountService accountService;

    @Autowired
    ClientValidator clientValidator;

    @InitBinder
    public void myInitBinder(WebDataBinder dataBinder){
        Object target = dataBinder.getTarget();
        if (target == null) {
            return;
        }
        if (target.getClass() == Account.class) {
            dataBinder.setValidator(clientValidator);
        }
    }

    @RequestMapping("/login")
    public String loginClient(Model model){
        return "/viewLogin";
    }

    @RequestMapping("/default")
    public String afterLogin(HttpServletRequest request){
        if (request.isUserInRole("ROLE_ADMIN"))
            return "redirect:/admin";
        return "redirect:index";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerClient(HttpServletRequest request, Model model){
        if (!request.isUserInRole("ROLE_CLIENT") ) {
            model.addAttribute("clientR", new Account());
            return "/viewRegistration";
        }
        return "redirect:/index";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerClient(@ModelAttribute("clientR") @Validated Account account, BindingResult result){
        if (result.hasErrors()){
            return "/viewRegistration";
        }
        account.setActive(true);
        account.setRole("CLIENT");
        registrationService.createAccount(account);
        return "/viewAfterRegistration";
    }

    @RequestMapping("/clientInfo")
    public String clientInfo(HttpServletRequest request, Map<String, Object> map){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = null;
        if ((auth instanceof AnonymousAuthenticationToken))
            return "redirect:/cart";
        userDetails = (UserDetails) auth.getPrincipal();
        Account account = accountService.findAccount(userDetails.getUsername());
        map.put("client",account);
        return "/viewClientInfo";
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String clientOrders(@RequestParam(value = "client", defaultValue = "") String login, Map<String,Object> map){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = null;
        userDetails = (UserDetails) auth.getPrincipal();
        if (!userDetails.getUsername().equals(login)){
            return "/error403";
        }
        List<OrderList> orderList = orderService.listClientOrders(login);
        map.put("orderList",orderList);
        return "/viewClientOrders";
    }
}
