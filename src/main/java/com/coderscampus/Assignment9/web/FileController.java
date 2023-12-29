package com.coderscampus.Assignment9.web;

import com.coderscampus.Assignment9.domain.Recipe;
import com.coderscampus.Assignment9.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FileController {

    private final FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/gluten-free")
    public List<Recipe> displayGlutenFreeRecipes() {

        return fileService.getRecipes().stream()
                .filter(Recipe::getGlutenFree)
                .collect(Collectors.toList());
    }


    @GetMapping("/vegan")
    public List<Recipe> displayVeganRecipes() {

        return fileService.getRecipes().stream()
                .filter(Recipe::getVegan)
                .collect(Collectors.toList());
    }

    @GetMapping("/vegan-and-gluten-free")
    public List<Recipe> displayVeganAndGlutenFreeRecipes() {

        return fileService.getRecipes().stream()
                .filter(recipe -> recipe.getVegan() && recipe.getGlutenFree())
                .collect(Collectors.toList());
    }

    @GetMapping("/vegetarian")
    public List<Recipe> displayVegetarianRecipes() {

        return fileService.getRecipes().stream()
                .filter(Recipe::getVegetarian)
                .collect(Collectors.toList());
    }


    @GetMapping("/all-recipes")

    public List<Recipe> displayAllRecipes() {
        return fileService.getRecipes();
    }

}
