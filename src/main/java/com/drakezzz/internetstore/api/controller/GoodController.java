package com.drakezzz.internetstore.api.controller;

import com.drakezzz.internetstore.api.dto.GoodDto;
import com.drakezzz.internetstore.service.GoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v2/good")
@RequiredArgsConstructor
public class GoodController {

    private final GoodService goodService;

    @GetMapping
    public List<GoodDto> getGoods() {
        return goodService.listGood();
    }

    @GetMapping("/category/{categoryId}")
    public List<GoodDto> getGoodsById(@PathVariable Long categoryId) {
        return goodService.listGoodByCategory(categoryId);
    }

}
