package com.example.practice5.jpa.repository;

import com.example.practice5.jpa.model.Recipe;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class RecipeRepositoryTest {
    @Autowired
    private RecipeRepository recipeRepository;

    @DisplayName("recipe select all 문")
    @Test
    void selectAllRecipe() {
        Recipe recipe1 = Recipe.builder()
                        .recipeNo(1L)
                        .recipeName("김치전")
                        .time("20분")
                        .difficulty("보통")
                        .cdatetime(LocalDateTime.now())
                        .build();
        recipeRepository.save(recipe1);
        Recipe recipe2 = Recipe.builder()
                .recipeNo(2L)
                .recipeName("감자전")
                .time("30분")
                .difficulty("보통")
                .cdatetime(LocalDateTime.now())
                .build();
        recipeRepository.save(recipe2);
        Recipe recipe3 = Recipe.builder()
                .recipeNo(3L)
                .recipeName("부추전")
                .time("35분")
                .difficulty("어려움")
                .cdatetime(LocalDateTime.now())
                .build();
        recipeRepository.save(recipe3);

        System.out.println("select all문---------------------------------------------");
        List<Recipe> recipeList = recipeRepository.findAll();
        recipeList.forEach(System.out::println);
    }
}
