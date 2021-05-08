package sewa.practice.recipeapp.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import sewa.practice.recipeapp.domain.Recipe;
import sewa.practice.recipeapp.service.RecipeService;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class IndexControllerTest {

    IndexController indexController;
    @Mock
    RecipeService recipeService;
    @Mock
    Model model;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        indexController = new IndexController(recipeService);
    }

    @Test
    void mockMvc() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    void index() {
        //Given
        Set<Recipe> recipes = new HashSet<>(){{
            add(Recipe.builder().Id(1L).build());
            add(Recipe.builder().Id(2L).build());
        }};
        when(recipeService.getRecepies()).thenReturn(recipes);
        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        //When
        String str = indexController.index(model);

        //Then
        assertEquals(str,"index");
        verify(recipeService,times(1)).getRecepies();
        verify(model,times(1)).addAttribute(eq("recipes"),argumentCaptor.capture());
        assertEquals(argumentCaptor.getValue().size(),2);
    }
}