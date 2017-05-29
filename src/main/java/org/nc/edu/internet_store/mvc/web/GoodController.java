package org.nc.edu.internet_store.mvc.web;

import java.util.Map;

import org.nc.edu.internet_store.mvc.domain.Cart;
import org.nc.edu.internet_store.mvc.domain.Category;
import org.nc.edu.internet_store.mvc.domain.Good;
import org.nc.edu.internet_store.mvc.service.CategoryService;
import org.nc.edu.internet_store.mvc.service.GoodService;

import org.nc.edu.internet_store.mvc.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletRequest;

@Controller
public class GoodController {

    @Autowired
    private GoodService goodService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/index" ,method = RequestMethod.GET)
    public String listGoods(Map<String,Object> map){
        map.put("Category", new Category());
        map.put("CategoryList", categoryService.listCategory());
        map.put("Good", new Good());
        map.put("GoodList",goodService.listGood());
        return "/viewGood";
    }

    @RequestMapping(value = "goods/{categoryId}",method = RequestMethod.GET)
    public String listGoodsAtCategory(@PathVariable("categoryId") Integer categoryId, Map<String, Object> map){
        map.put("Good", new Good());
        map.put("GoodList",goodService.listGoodByCategory(categoryId));
        return "/viewGoodsAtCategory";
    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping("/addToCart/{id}")
    public String listGoodHandler(HttpServletRequest request, @PathVariable("id") Integer id){
        Good good = null;
        if (id !=null)
            good = goodService.listGoodById(id).get(0);
        if (good != null){
            Cart cart = Utils.getCartInSession(request);
            cart.AddItem(good,1);
        }
        return "redirect:/cart";
    }

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
            good = goodService.listGoodById(id).get(0);
        }

        if (good != null){
            Cart cart = Utils.getCartInSession(request);
            cart.removeGood(id);
        }
        return "redirect:/cart";
    }
}
