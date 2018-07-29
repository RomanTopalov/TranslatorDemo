package com.ua.dao;

import com.ua.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category,String> {
}
