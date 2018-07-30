package com.ua.controllers;

import com.ua.converters.CategoryToCategoryDto;
import com.ua.dto.CategoryDto;
import com.ua.entities.Category;
import com.ua.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

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

    @RequestMapping({"category/list", "category"})
   public String listCategories(Model model){
        model.addAttribute("categories", categoryService.listAll());
        return "category/list";
   }

    @RequestMapping("/category/show/{id}")
    public  String getCategory(@PathVariable String id, Model model){
        model.addAttribute("category", categoryService.getById(id));
        return "category/show";
    }
   @RequestMapping("category/edit/{id}")
   public String editCategory(@PathVariable String id, Model model){
       Category category = categoryService.getById(id);
       CategoryDto categoryDto = categoryToCategoryDto.convert(category);

       model.addAttribute("categoryDto",categoryDto);
        return "category/categoryDto";
   }

   @RequestMapping("category/new")
   public  String newCategory(Model model){
        model.addAttribute("categoryDto", new CategoryDto());
        return "category/categoryDto";
   }

    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public String saveOrUpdateCategory(@Valid CategoryDto categoryDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "category/categoryDto";
        }
        Category savedCategory = categoryService.saveOrUpdateCategoryDto(categoryDto);
        return "redirect:/category/show/" + savedCategory.getId();
    }

    @RequestMapping("/category/delete/{id}")
    public String deleteCategory(@PathVariable String id){
        categoryService.delete(id);
        return "redirect:/category/list";
    }


}
