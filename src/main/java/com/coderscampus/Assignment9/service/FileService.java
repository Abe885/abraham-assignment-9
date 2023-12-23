package com.coderscampus.Assignment9.service;

import com.coderscampus.Assignment9.domain.Recipe;
import jakarta.annotation.PostConstruct;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {
    List<Recipe> recipes = new ArrayList<>();

    public FileService() {

    }

    @PostConstruct
    public void init()  {
        String fileName = "recipes.txt";
        try{
             readRecipesFromCSV(fileName);
        } catch (IOException e) {
            throw new RuntimeException("Error reading from file: " + fileName, e);
        }
    }


        private void readRecipesFromCSV(String fileName) throws IOException {
            Reader in = new FileReader(fileName);
            Iterable<CSVRecord> records = CSVFormat.Builder.create(CSVFormat.DEFAULT)
                    .setIgnoreSurroundingSpaces(true)
                    .setQuote('"')
                    .setEscape('\\')
                    .setHeader()
                    .setSkipHeaderRecord(true)
                    .build()
                    .parse(in);
            for (CSVRecord record : records) {
                recipes.add(parseCSVRecordToRecipe(record));
            }
        }

        private Recipe parseCSVRecordToRecipe(CSVRecord record) {
            Recipe recipe = new Recipe();

            recipe.setCookingMinutes(Integer.parseInt(record.get("Cooking Minutes")));
            recipe.setDairyFree(Boolean.parseBoolean(record.get("Dairy Free")));
            recipe.setGlutenFree(Boolean.parseBoolean(record.get("Gluten Free")));
            recipe.setInstructions(record.get("Instructions"));
            recipe.setPreparationMinutes(Double.parseDouble(record.get("Preparation Minutes")));
            recipe.setPricePerServing(Double.parseDouble(record.get("Price Per Serving")));
            recipe.setReadyInMinutes(Integer.parseInt(record.get("Ready In Minutes")));
            recipe.setServings(Integer.parseInt(record.get("Servings")));
            recipe.setSpoonacularScore(Double.parseDouble(record.get("Spoonacular Score")));
            recipe.setTitle(record.get("Title"));
            recipe.setVegan(Boolean.parseBoolean(record.get("Vegan")));
            recipe.setVegetarian(Boolean.parseBoolean(record.get("Vegetarian")));

            return recipe;
        }

    public List<Recipe> getRecipes() {
        return recipes;
    }
}
