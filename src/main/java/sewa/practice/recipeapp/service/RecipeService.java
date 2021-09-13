package sewa.practice.recipeapp.service;

import sewa.practice.recipeapp.commands.RecipeCommand;
import sewa.practice.recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
