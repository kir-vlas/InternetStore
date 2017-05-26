package org.nc.edu.internet_store.mvc.web;

import java.util.Map;

import org.nc.edu.internet_store.mvc.domain.Category;
import org.nc.edu.internet_store.mvc.domain.Good;
import org.nc.edu.internet_store.mvc.service.CategoryService;
import org.nc.edu.internet_store.mvc.service.GoodService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;

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
        map.put("GoodList",goodService.listGood(categoryId));
        return "/viewGoodsAtCategory";
    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }
}
