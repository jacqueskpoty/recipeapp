package sewa.practice.recipeapp.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sewa.practice.recipeapp.service.RecipeService;

@Controller
@Slf4j
@RequiredArgsConstructor
public class IndexController {

    private final RecipeService recipeService;

    @RequestMapping({"","/","/index","/index.html"})
    public String index(Model model){
        model.addAttribute("recipes",recipeService.getRecepies());
        return "index";
    }

}
