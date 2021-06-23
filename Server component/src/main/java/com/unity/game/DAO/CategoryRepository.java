package com.unity.game.DAO;

import java.util.List;

import com.unity.game.model.Category;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, String> {

    @Query(value="select * from category r where r.category_Text =?1", nativeQuery = true)
    public List<Category> findByCategory(String categoryText);
}
