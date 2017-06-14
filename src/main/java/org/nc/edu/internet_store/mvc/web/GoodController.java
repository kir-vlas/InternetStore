package org.nc.edu.internet_store.mvc.web;

import java.io.IOException;
import java.util.Map;

import org.nc.edu.internet_store.mvc.domain.Cart;
import org.nc.edu.internet_store.mvc.domain.Category;
import org.nc.edu.internet_store.mvc.domain.Good;
import org.nc.edu.internet_store.mvc.service.CategoryService;
import org.nc.edu.internet_store.mvc.service.GoodService;

import org.nc.edu.internet_store.mvc.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        return "/viewIndex";
    }

    @RequestMapping(value = "/good", method = RequestMethod.GET)
    public String showGood(@RequestParam(value = "id", defaultValue = "0") String idStr, Map<String,Object> map){
        Integer id = Integer.parseInt(idStr);
        map.put("good", goodService.listGoodById(id));
        return "/viewGood";
    }

    @RequestMapping(value = "goods/{categoryId}",method = RequestMethod.GET)
    public String listGoodsAtCategory(@PathVariable("categoryId") Integer categoryId, Map<String, Object> map){
        map.put("Category", new Category());
        map.put("CategoryList", categoryService.listCategory());
        map.put("Good", new Good());
        map.put("GoodList",goodService.listGoodByCategory(categoryId));
        return "/viewGoodsAtCategory";
    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/addToCart")
    @ResponseBody
    public void listGoodHandler(HttpServletRequest request, @RequestParam(value = "good") Integer id){
        Good good = null;
        if (id !=null)
            good = goodService.listGoodById(id);
        if (good != null){
            Cart cart = Utils.getCartInSession(request);
            cart.AddItem(good,1);
        }
    }

    @RequestMapping("/image")
    public void showImage(HttpServletRequest request, HttpServletResponse response,
                          @RequestParam(value = "id", defaultValue = "0") Integer id) throws IOException{
        Good good = goodService.listGoodById(id);
        if (good.getImage() != null){
            response.setContentType("image/jpeg, image/jpg, image/png");
            response.getOutputStream().write(good.getImage());
        }
        response.getOutputStream().close();
    }
}
