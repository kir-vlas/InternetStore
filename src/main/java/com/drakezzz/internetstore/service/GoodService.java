package com.drakezzz.internetstore.service;

import com.drakezzz.internetstore.api.dto.GoodDto;
import com.drakezzz.internetstore.entity.Good;

import java.util.List;

public interface GoodService {
    public void addGood(Good good);

    public List<GoodDto> listGood();

    public List<GoodDto> listGoodByCategory(Long Id);

    public Good listGoodById(Long Id);

    public void updateGood(Good good);

    public void deleteGood(Long id);
}
