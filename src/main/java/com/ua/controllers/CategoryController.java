package com.ua.controllers;

import com.ua.converters.CategoryToCategoryDto;
import com.ua.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class CategoryController {

   private CategoryService categoryService;
   private CategoryToCategoryDto categoryToCategoryDto;

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @Autowired
    public void setCategoryToCategoryDto(CategoryToCategoryDto categoryToCategoryDto) {
        this.categoryToCategoryDto = categoryToCategoryDto;
    }

   public String listCategories(Model model){
        model.addAttribute("categories", categoryService.listAll());
        return "category/list";
   }

}
