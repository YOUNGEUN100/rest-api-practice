package com.example.practice5.jpa.repository;

import com.example.practice5.jpa.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
