package com.drakezzz.internetstore.service.impl;

import com.drakezzz.internetstore.api.dto.CategoryDto;
import com.drakezzz.internetstore.entity.GoodCategory;
import com.drakezzz.internetstore.repository.CategoryRepository;
import com.drakezzz.internetstore.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public void addCategory(GoodCategory category){
        categoryRepository.save(category);
    }

    public List<CategoryDto> listCategory(){
        return categoryRepository.findAll()
                .stream()
                .map(CategoryDto::of)
                .collect(Collectors.toList());
    }

    public void updateCategory(GoodCategory category){
        categoryRepository.save(category);
    }

    public GoodCategory findCategoryById(Long id){
        return categoryRepository
                .findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    public void removeCategory(Long id){
        categoryRepository.deleteById(id);
    }
}
