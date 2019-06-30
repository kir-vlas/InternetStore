package com.drakezzz.internetstore.service.impl;

import com.drakezzz.internetstore.api.dto.CategoryDto;
import com.drakezzz.internetstore.api.dto.GoodDto;
import com.drakezzz.internetstore.api.dto.StatusResult;
import com.drakezzz.internetstore.api.dto.SummaryData;
import com.drakezzz.internetstore.entity.Good;
import com.drakezzz.internetstore.entity.GoodCategory;
import com.drakezzz.internetstore.service.AdminService;
import com.drakezzz.internetstore.service.CategoryService;
import com.drakezzz.internetstore.service.GoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final GoodService goodService;

    private final CategoryService categoryService;

    @Override
    public SummaryData getGoodsWithCategories() {
        List<GoodDto> goodDtoList = goodService.listGood();
        List<CategoryDto> categories = categoryService.listCategory();

        return new SummaryData(goodDtoList, categories);
    }

    @Override
    public StatusResult saveCategory(CategoryDto categoryDto) {
        GoodCategory category = GoodCategory.of(categoryDto);
        categoryService.addCategory(category);
        return StatusResult.ok();
    }

    @Override
    public StatusResult saveGood(GoodDto goodDto) {
        Good good = Good.of(goodDto);
        goodService.addGood(good);
        return StatusResult.ok();
    }

    @Override
    public StatusResult deleteGood(Long id) {
        goodService.deleteGood(id);
        return StatusResult.ok();
    }

    @Override
    public StatusResult deleteCategory(Long id) {
        categoryService.removeCategory(id);
        return StatusResult.ok();
    }

}
