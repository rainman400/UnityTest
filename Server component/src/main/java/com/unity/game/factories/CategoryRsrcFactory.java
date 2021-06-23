package com.unity.game.factories;

import java.util.ArrayList;
import java.util.List;

import com.unity.game.model.Category;
import com.unity.game.resources.CategoryListRsrc;
import com.unity.game.resources.CategoryRsrc;

import org.springframework.stereotype.Component;

@Component
public class CategoryRsrcFactory implements CategoryResourceFactory{

    @Override
    public CategoryRsrc populate(Category categoryDto, CategoryRsrc resource) {
        resource.setCategoryId(categoryDto.getCategoryId());
        resource.setCategoryText(categoryDto.getCategoryText());
        return resource;
    }

    @Override
    public Category applyModel(Category categoryDto, CategoryRsrc resource) {
        
        categoryDto.setCategoryId(resource.getCategoryId());
        categoryDto.setCategoryText(resource.getCategoryText());

        return categoryDto;
    }

    @Override
    public CategoryListRsrc populateCategoriesList(List<Category> categoryListDto, CategoryListRsrc resource) {
        List<CategoryRsrc> categories = new ArrayList<>();
        for(Category game : categoryListDto) {
            CategoryRsrc rsrc = new CategoryRsrc();
            rsrc = populate(game,rsrc);
            categories.add(rsrc);
        }
        resource.setCategories(categories);
        return resource;
    }
    
}
