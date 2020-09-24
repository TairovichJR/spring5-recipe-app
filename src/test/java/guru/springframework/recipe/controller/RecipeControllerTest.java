package guru.springframework.recipe.controller;
/**
 * Created by tairovich_jr on Sep 23, 2020
 */

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import guru.springframework.recipe.controllers.RecipeController;
import guru.springframework.recipe.domain.Recipe;
import guru.springframework.recipe.services.RecipeService;

public class RecipeControllerTest {

	@Mock
	RecipeService recipeService;
	
	RecipeController controller;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		controller = new RecipeController(recipeService);
	}
	
	
	@Test
	public void getRecipeById() throws Exception {
		Recipe recipe = Recipe.builder().id(1L).build();
		
		MockMvc mvcMvc = MockMvcBuilders.standaloneSetup(controller).build();
		
		when(recipeService.findById(anyLong())).thenReturn(recipe);
		
		mvcMvc.perform(get("/recipe/show/1"))
				.andExpect(status().is(200))
				.andExpect(view().name("/recipe/show"))
				.andExpect(model().attributeExists("recipe"));
				
	}
	
	
	
	
	
}
