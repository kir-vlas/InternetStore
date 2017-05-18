package org.nc.edu.internet_store.mvc.web;

import java.util.Map;

import org.nc.edu.internet_store.mvc.domain.Category;
import org.nc.edu.internet_store.mvc.service.CategoryService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @RequestMapping(value = "/index" ,method = RequestMethod.GET)
    public String listCategories(Map<String, Object> map){
        map.put("Category", new Category());
        map.put("CategoryList", categoryService.listCategory());
        return "/viewCategory";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCategory(@ModelAttribute("category") Category Category,
                             BindingResult result) {

        categoryService.addCategory(Category);

        return "redirect:/index";
    }

    @RequestMapping("/delete/{categoryId}")
    public String deleteContact(@PathVariable("categoryId") Integer categoryId) {

        categoryService.removeCategory(categoryId);

        return "redirect:/index";
    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }
}
