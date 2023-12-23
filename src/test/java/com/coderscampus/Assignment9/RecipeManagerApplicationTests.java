package com.coderscampus.Assignment9;

import com.coderscampus.Assignment9.domain.Recipe;
import com.coderscampus.Assignment9.service.FileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
public class RecipeManagerApplicationTests {

	@Autowired
	private FileService fileService;

	@Test
	public void testFileProcessing() {
		List<Recipe> recipes = fileService.getRecipes();

		assertNotNull(recipes);
		assertFalse(recipes.isEmpty());
	}

}
