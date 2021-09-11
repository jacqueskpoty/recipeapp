package sewa.practice.recipeapp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sewa.practice.recipeapp.domain.Recipe;
import sewa.practice.recipeapp.repository.RecipeRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService{

    private final RecipeRepository recipeRepository;

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipiesSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipiesSet::add);
        return recipiesSet;
    }

    @Override
    public Recipe findById(Long id) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(id);

        if (!recipeOptional.isPresent()) {
            throw new RuntimeException("Recipe Not Found!");
        }

        return recipeOptional.get();
    }
}
