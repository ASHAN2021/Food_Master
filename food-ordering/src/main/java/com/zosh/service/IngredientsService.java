package com.zosh.service;

import com.zosh.model.IngrediantCategory;
import com.zosh.model.IngrediantsItem;

import java.util.List;

public interface IngredientsService {

    public IngrediantCategory createIngredientCategory(String name,Long restaurantId) throws Exception;

    public IngrediantCategory findIngredientCategoryById(Long id) throws Exception;

    public List<IngrediantCategory> findIngredientCategoryByRestaurantId(Long id) throws Exception;

    public IngrediantsItem createIngredientsItem(Long restaurantId,String ingredientName,Long categoryId) throws Exception;

    public List<IngrediantsItem>  findRestaurantsIngredients(Long restaurantId);

    public IngrediantsItem updateStock(Long id) throws Exception;


}
