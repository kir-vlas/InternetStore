package com.drakezzz.internetstore.api.controller;

import com.drakezzz.internetstore.api.dto.CategoryDto;
import com.drakezzz.internetstore.api.dto.GoodDto;
import com.drakezzz.internetstore.api.dto.StatusResult;
import com.drakezzz.internetstore.api.dto.SummaryData;
import com.drakezzz.internetstore.service.AdminService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v2/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping
    @ApiOperation("Getting all categories and goods")
    public SummaryData getGoodsWithCategories() {
        return adminService.getGoodsWithCategories();
    }

    @PutMapping("/category")
    @ApiOperation("Saving category")
    public StatusResult saveCategory(@RequestBody @Valid CategoryDto category) {
        return adminService.saveCategory(category);
    }

    @PutMapping("/good")
    @ApiOperation("Saving good")
    public StatusResult saveGood(@RequestBody @Valid GoodDto good) {
        return adminService.saveGood(good);
    }

    @DeleteMapping("/good/{id}")
    @ApiOperation("Deleting good")
    public StatusResult deleteGood(@PathVariable Long id) {
        return adminService.deleteGood(id);
    }

    @DeleteMapping("/category/{id}")
    @ApiOperation("Deleting category with goods")
    public StatusResult deleteCategory(@PathVariable Long id) {
        return adminService.deleteCategory(id);
    }

}
