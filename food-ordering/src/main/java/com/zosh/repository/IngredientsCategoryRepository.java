package com.zosh.repository;

import com.zosh.model.IngrediantCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientsCategoryRepository extends JpaRepository<IngrediantCategory,Long> {

     List<IngrediantCategory> findByRestaurantId(Long id);
}
