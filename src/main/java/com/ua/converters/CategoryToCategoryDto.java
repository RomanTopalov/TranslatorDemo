package com.ua.converters;


import com.ua.dto.CategoryDto;
import com.ua.entities.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryToCategoryDto implements Converter<Category, CategoryDto> {

    @Override
    public CategoryDto convert(Category category) {

        CategoryDto categoryDto = new CategoryDto();
            categoryDto.setId(category.getId().toHexString());
            categoryDto.setName(category.getName());
        return categoryDto;
    }
}
