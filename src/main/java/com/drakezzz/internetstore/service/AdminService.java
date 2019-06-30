package com.drakezzz.internetstore.service;

import com.drakezzz.internetstore.api.dto.CategoryDto;
import com.drakezzz.internetstore.api.dto.GoodDto;
import com.drakezzz.internetstore.api.dto.StatusResult;
import com.drakezzz.internetstore.api.dto.SummaryData;

public interface AdminService {

    SummaryData getGoodsWithCategories();

    StatusResult saveCategory(CategoryDto categoryDto);

    StatusResult saveGood(GoodDto goodDto);

    StatusResult deleteGood(Long id);

    StatusResult deleteCategory(Long id);

}
