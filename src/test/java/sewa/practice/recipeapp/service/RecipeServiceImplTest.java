package sewa.practice.recipeapp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sewa.practice.recipeapp.domain.Recipe;
import sewa.practice.recipeapp.repository.RecipeRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;
    @Mock
    RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    void getRecepies() {
        Set<Recipe> recipeData = new HashSet<>(){{
            add(new Recipe());
        }};
        when(recipeRepository.findAll()).thenReturn(recipeData);
        Set<Recipe> recipeSet = recipeService.getRecipes();
        assertEquals(recipeSet.size(),1);
        verify(recipeRepository, times(1)).findAll();
    }

    @Test
    void getRecipeById() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptimal = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptimal);

        Recipe toReturn = recipeService.findById(1L);

        assertNotNull(toReturn);
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, never()).findAll();
    }
}