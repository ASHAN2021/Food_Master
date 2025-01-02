package com.zosh.service;

import com.zosh.model.IngrediantCategory;
import com.zosh.model.IngrediantsItem;
import com.zosh.model.Restaurant;
import com.zosh.repository.IngredientItemRepository;
import com.zosh.repository.IngredientsCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceImp implements IngredientsService{

    @Autowired
    private IngredientItemRepository ingredientItemRepository;

    @Autowired
    private IngredientsCategoryRepository ingredientsCategoryRepository;

    @Autowired
    private RestaurantService restaurantService;

    @Override
    public IngrediantCategory createIngredientCategory(String name, Long restaurantId) throws Exception {
        Restaurant restaurant = restaurantService.findRestaurantById(restaurantId);
        IngrediantCategory category = new IngrediantCategory();
        category.setName(name);
        category.setRestaurant(restaurant);
        return ingredientsCategoryRepository.save(category);
    }

    @Override
    public IngrediantCategory findIngredientCategoryById(Long id) throws Exception {
        Optional<IngrediantCategory> opt = ingredientsCategoryRepository.findById(id);
        if(opt.isEmpty()){
            throw new Exception("ingredient categoey not found");
        }
        return opt.get();
    }

    @Override
    public List<IngrediantCategory> findIngredientCategoryByRestaurantId(Long id) throws Exception {
        restaurantService.findRestaurantById(id);
        return ingredientsCategoryRepository.findByRestaurantId(id);

    }

    @Override
    public IngrediantsItem createIngredientsItem(Long restaurantId, String ingredientName, Long categoryId) throws Exception {
        Restaurant restaurant = restaurantService.findRestaurantById(restaurantId);
        IngrediantCategory category = findIngredientCategoryById(categoryId);

        IngrediantsItem item = new IngrediantsItem();
        item.setRestaurant(restaurant);
        item.setName(ingredientName);
        item.setCategory(category);

        IngrediantsItem ingredient = ingredientItemRepository.save(item);
        category.getIngrediants().add(ingredient);
        return ingredient;
    }

    @Override
    public List<IngrediantsItem> findRestaurantsIngredients(Long restaurantId) {
        return ingredientItemRepository.findByRestaurantId(restaurantId);
    }

    @Override
    public IngrediantsItem updateStock(Long id) throws Exception {
        Optional<IngrediantsItem> optionalIngrediantsItem = ingredientItemRepository.findById(id);
        if(optionalIngrediantsItem.isEmpty()){
            throw new Exception("ingredients  not found");
        }
        IngrediantsItem ingrediantsItem = optionalIngrediantsItem.get();
        ingrediantsItem.setInStoke(!ingrediantsItem.isInStoke());
        return ingredientItemRepository.save(ingrediantsItem);
    }
}
