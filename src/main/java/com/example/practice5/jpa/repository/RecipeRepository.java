package com.example.practice5.jpa.repository;

import com.example.practice5.jpa.model.Recipe;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query(value = "select r.recipe_name name from recipe r where :recipe_no")
    List<Recipe> findByIdByMyRecipe(@Param("recipe_no") Long recipeNo);


}
