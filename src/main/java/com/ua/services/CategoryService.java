package com.ua.services;

import com.ua.dto.CategoryDto;
import com.ua.entities.Category;

import java.util.List;

public interface CategoryService {

    List<Category> listAll();

    Category getById(String id);

    Category saveOrUpdate(Category category);

    void delete(String id);

    Category saveOrUpdateCategoryDto(CategoryDto categoryDto);
}
