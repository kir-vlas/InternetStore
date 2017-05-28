package org.nc.edu.internet_store.mvc.web;

import org.nc.edu.internet_store.mvc.domain.Category;
import org.nc.edu.internet_store.mvc.service.CategoryService;
import org.nc.edu.internet_store.mvc.domain.Good;
import org.nc.edu.internet_store.mvc.service.GoodService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Map;

@Controller
@EnableWebMvc
public class AdminController {

    @Autowired
    private GoodService goodService;

    @Autowired
    private CategoryService categoryService;


    @RequestMapping(value = "/adminlogin", method = RequestMethod.GET)
    public String login(Model model){
        return "/viewLogin";
    }


    @RequestMapping(value = "/admin" ,method = RequestMethod.GET)
    public String listCategories(Map<String, Object> map){
        map.put("Category", new Category());
        map.put("CategoryList", categoryService.listCategory());
        return "/viewAdmin";
    }

    @RequestMapping(value = "admin/add", method = RequestMethod.POST)
    public String addCategory(@ModelAttribute("category") Category Category,
                              BindingResult result) {

        categoryService.addCategory(Category);

        return "redirect:/admin";
    }

    @RequestMapping("admin/delete/{categoryId}")
    public String deleteContact(@PathVariable("categoryId") Integer categoryId) {

        categoryService.removeCategory(categoryId);

        return "redirect:/admin";
    }
}
