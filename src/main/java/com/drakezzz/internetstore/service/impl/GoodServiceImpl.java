package com.drakezzz.internetstore.service.impl;

import com.drakezzz.internetstore.api.dto.GoodDto;
import com.drakezzz.internetstore.entity.Good;
import com.drakezzz.internetstore.repository.GoodRepository;
import com.drakezzz.internetstore.service.GoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GoodServiceImpl implements GoodService {

    private final GoodRepository goodRepository;

    public void addGood(Good good) {
        goodRepository.save(good);
    }

    public List<GoodDto> listGood() {
        return goodRepository.findAll()
                .stream()
                .map(GoodDto::of)
                .collect(Collectors.toList());
    }

    public List<GoodDto> listGoodByCategory(Long id) {
        return goodRepository.findByCategory(id)
                .stream()
                .map(GoodDto::of)
                .collect(Collectors.toList());
    }

    public Good listGoodById(Long id){
        return goodRepository
                .findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    public void updateGood(Good good){
        goodRepository.save(good);
    }

    public void deleteGood(Long id) {
        goodRepository.deleteById(id);
    }
}
