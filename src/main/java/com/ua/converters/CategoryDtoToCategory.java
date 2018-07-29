package com.ua.converters;

import com.ua.dto.CategoryDto;
import com.ua.entities.Category;
import org.bson.types.ObjectId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class CategoryDtoToCategory implements Converter<CategoryDto,Category> {
    @Override
    public Category convert(CategoryDto categoryDto) {
        Category category = new Category();

        if (categoryDto.getId() !=null && !StringUtils.isEmpty(categoryDto.getId())){
            categoryDto.setId( new ObjectId(categoryDto.getId()).toHexString());
        }
        category.setName(categoryDto.getName());
        return category;
    }
}
