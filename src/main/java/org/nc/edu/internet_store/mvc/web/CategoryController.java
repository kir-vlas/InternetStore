package org.nc.edu.internet_store.mvc.web;

import java.util.Map;

import org.nc.edu.internet_store.mvc.domain.Category;
import org.nc.edu.internet_store.mvc.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CategoryController {


    private CategoryService categoryService;

    @RequestMapping("/index")
    public String listCategories(Map<String, Object> map){
        map.put("Category", new Category());
        map.put("CategoryList", categoryService.listCategory());
        return "Category";
    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }
}
