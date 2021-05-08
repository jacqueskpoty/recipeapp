package sewa.practice.recipeapp.repository;

import org.springframework.data.repository.CrudRepository;
import sewa.practice.recipeapp.domain.UnitOfMeasure;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure,Long> {
    Optional<UnitOfMeasure> findByUom(String description);
}
