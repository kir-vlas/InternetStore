package org.nc.edu.internet_store.mvc.web;

import org.nc.edu.internet_store.mvc.domain.Category;
import org.nc.edu.internet_store.mvc.service.CategoryService;
import org.nc.edu.internet_store.mvc.domain.Good;
import org.nc.edu.internet_store.mvc.service.GoodService;

import org.nc.edu.internet_store.mvc.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@EnableWebMvc
public class AdminController {

    @Autowired
    private GoodService goodService;

    @Autowired
    private CategoryService categoryService;


    @RequestMapping(value = "/adminLogin", method = RequestMethod.GET)
    public String login(Model model){
        return "/viewLogin";
    }


    @RequestMapping(value = "/admin" ,method = RequestMethod.GET)
    public String listCategories(Map<String, Object> map){
        map.put("Category", new Category());
        map.put("CategoryList", categoryService.listCategory());
        map.put("Good", new Good());
        map.put("GoodList",goodService.listGood());
        return "/viewAdmin";
    }

    @RequestMapping(value = "/admin/addCategory", method = RequestMethod.POST)
    public String addCategory(@ModelAttribute("category") Category Category,
                              BindingResult result) {

        categoryService.addCategory(Category);

        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin/editCategory/{categoryId}", method = RequestMethod.GET)
    public String showEditCategory(@PathVariable("categoryId") Integer id, Map<String,Object> map){
        map.put("oldCategory",categoryService.findCategoryById(id));
        map.put("newCategory", new Category());
        return "/viewEditCategory";

    }

    @RequestMapping(value = "admin/editCat", method = RequestMethod.POST)
    public String editCategory(@ModelAttribute("newCategory") Category category){
        categoryService.updateCategory(category);
        return "redirect:/admin";
    }

    @RequestMapping("/admin/addGood")
    public String addGoodInCategory(@RequestParam(value = "id",defaultValue = "0") String idStr, Map<String,Object> map, HttpServletRequest request){
        Integer id = Integer.parseInt(idStr);

        if (id == 0) return "redirect:/admin";
        map.put("good", new Good());
        Category category = categoryService.findCategoryById(id);
        map.put("category", category);
        Utils.saveCategory(request, category);
        return "/viewAdminGoods";
    }

    @RequestMapping(value = "/admin/addGood/add",method = RequestMethod.POST)
    public String addGood(@ModelAttribute("good") Good good, BindingResult result, HttpServletRequest request){
        good.setCategory(Utils.getSavedCategory(request));
        goodService.addGood(good);

        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin/editGood/{goodId}")
    public String editGood(@PathVariable("goodId") Integer id, Map<String,Object> map,HttpServletRequest request){
        map.put("newGood", new Good());
        Good good = goodService.listGoodById(id);
        Utils.saveCategory(request,good.getCategory());
        map.put("oldGood",good);
        return "/viewEditGood";
    }

    @RequestMapping(value = "/admin/updateGood", method = RequestMethod.POST)
    public String updateGood(@ModelAttribute("newGood") Good good,HttpServletRequest request){
        good.setCategory(Utils.getSavedCategory(request));
        good.setDescription(request.getParameter("newDesc"));
        goodService.updateGood(good);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin/deleteGood/{goodId}")
    public String deleteGood(@PathVariable("goodId") Integer goodId){
        goodService.deleteGood(goodId);
        return "redirect:/admin";
    }

    @RequestMapping("/admin/delete/{categoryId}")
    public String deleteCategory(@PathVariable("categoryId") Integer categoryId) {

        categoryService.removeCategory(categoryId);

        return "redirect:/admin";
    }
}
