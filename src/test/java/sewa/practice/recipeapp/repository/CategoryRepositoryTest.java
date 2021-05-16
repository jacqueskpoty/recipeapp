package sewa.practice.recipeapp.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import sewa.practice.recipeapp.domain.Category;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {

    }

    @Test
    void findByDescriptionTest(){
        Optional<Category> category = categoryRepository.findByDescription("American");
        assertEquals(category.get().getDescription(),"American");
    }
}