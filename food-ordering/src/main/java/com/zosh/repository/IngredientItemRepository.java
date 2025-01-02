package com.zosh.repository;

import com.zosh.model.IngrediantsItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientItemRepository extends JpaRepository<IngrediantsItem,Long> {

    List<IngrediantsItem> findByRestaurantId(Long id);
}
