package org.nc.edu.internet_store.mvc.web;

import org.nc.edu.internet_store.mvc.domain.Account;
import org.nc.edu.internet_store.mvc.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class ClientController {

    @Autowired
    RegistrationService registrationService;


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
    public String registerClient(HttpServletRequest request, Map<String,Object> map){
        if (!request.isUserInRole("ROLE_CLIENT") ) {
            map.put("account", new Account());
            return "/viewRegistration";
        }
        return "redirect:/index";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerClient(@ModelAttribute("client") Account account){
        account.setActive(true);
        account.setRole("CLIENT");
        registrationService.createAccount(account);
        return "/viewAfterRegistration";
    }

    @RequestMapping("/clientInfo")
    public String clientInfo(HttpServletRequest request){
        return "viewClientInfo";
    }
}
