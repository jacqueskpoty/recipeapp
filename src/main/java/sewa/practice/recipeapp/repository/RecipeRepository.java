package sewa.practice.recipeapp.repository;

import org.springframework.data.repository.CrudRepository;
import sewa.practice.recipeapp.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe,Long> {
}
