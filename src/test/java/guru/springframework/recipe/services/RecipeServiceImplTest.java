package guru.springframework.recipe.services;
/**
 * Created by tairovich_jr on Sep 15, 2020
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import guru.springframework.recipe.converters.RecipeCommandToRecipe;
import guru.springframework.recipe.converters.RecipeToRecipeCommand;
import guru.springframework.recipe.domain.Recipe;
import guru.springframework.recipe.repositories.RecipeRepository;

public class RecipeServiceImplTest {

	RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        recipeService = new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
    }


	@Test
	public void getRecipeById() throws Exception{
		
		Recipe recipe = Recipe.builder().id(1L).build();
		Optional<Recipe> recipeOptional = Optional.of(recipe);
		
		when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);
		
		Recipe recipeReturned = recipeService.findById(1L);
		
		assertNotNull(recipeReturned, "Null recipe returned");
		verify(recipeRepository,times(1)).findById(anyLong());
		verify(recipeRepository, never()).findAll();
	}
	
	
	@Test
	public void getRecipes() throws Exception{
		
		Set<Recipe> recipesData = new HashSet<>();
		recipesData.add(Recipe.builder().id(1L).description("simple recipe 1").build());
		recipesData.add(Recipe.builder().id(2L).description("simple recipe 2").build());
		
		when(recipeRepository.findAll()).thenReturn(recipesData);
		
		Set<Recipe> recipes = recipeService.getRecipes();
		
		assertEquals(2, recipes.size());
		verify(recipeRepository,times(1)).findAll();
	}
	
	
}