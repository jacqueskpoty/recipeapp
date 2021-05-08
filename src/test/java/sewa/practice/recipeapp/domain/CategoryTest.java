package sewa.practice.recipeapp.domain;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    Category category;

    @BeforeEach
    void setUp(){
        category = new Category();
    }

    @Test
    void getId() {
        Long Id = 4L;
        category.setId(Id);
        assertTrue(category.getId().equals(Id));
    }

    @Test
    void getDescription() {
    }

    @Test
    void getRecipies() {
    }
}