package com.ua.servicesImpl;

import com.ua.converters.CategoryDtoToCategory;
import com.ua.dao.CategoryRepository;
import com.ua.dto.CategoryDto;
import com.ua.entities.Category;
import com.ua.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    private CategoryDtoToCategory categoryDtoToCategory;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryDtoToCategory categoryDtoToCategory) {
        this.categoryRepository = categoryRepository;
        this.categoryDtoToCategory = categoryDtoToCategory;
    }

    @Override
    public List<Category> listAll() {
        List<Category> categories = new ArrayList<>();
        categoryRepository.findAll().forEach(categories::add);
        return categories;
    }

    @Override
    public Category getById(String id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category saveOrUpdate(Category category) {
        categoryRepository.save(category);
        return category;
    }

    @Override
    public void delete(String id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category saveOrUpdateCategoryDto(CategoryDto categoryDto) {
        Category saveCategory = saveOrUpdate(categoryDtoToCategory.convert(categoryDto));
        return saveCategory;
    }
}
