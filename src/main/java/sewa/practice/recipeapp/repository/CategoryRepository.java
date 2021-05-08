package sewa.practice.recipeapp.repository;

import org.springframework.data.repository.CrudRepository;
import sewa.practice.recipeapp.domain.Category;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category,Long> {

    Optional<Category> findByDescription(String description);
}
