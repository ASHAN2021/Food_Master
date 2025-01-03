package com.zosh.request;

import com.zosh.model.Category;
import com.zosh.model.IngrediantsItem;
import lombok.Data;

import java.util.List;

@Data
public class CreateFoodRequest {

    private String name;
    private String description;
    private Long price;

    private Category category;
    private List<String> images;

    private Long restaurantId;
    private boolean vegetarian;
    private boolean seasional;
    private List<IngrediantsItem> ingredients;
}
