package com.unity.game.factories;

import java.util.List;

import com.unity.game.model.Category;
import com.unity.game.resources.CategoryListRsrc;
import com.unity.game.resources.CategoryRsrc;

public interface CategoryResourceFactory {
    public CategoryRsrc populate(Category categoryDto, CategoryRsrc resource) ;
    public Category applyModel(Category categoryDto, CategoryRsrc resource);

    public CategoryListRsrc populateCategoriesList(List<Category> categoryListDto, CategoryListRsrc resource);
}
