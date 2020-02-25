package com.rms.dao;

import org.springframework.data.repository.CrudRepository;
import com.rms.model.Category;

public interface CategoryDao extends CrudRepository<Category, Integer> {

}
