package guru.springframework.recipe.services;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import guru.springframework.recipe.commands.IngredientCommand;
import guru.springframework.recipe.converters.IngredientToIngredientCommand;
import guru.springframework.recipe.converters.UnitOfMeasureToUnitOfMeasureCommand;
import guru.springframework.recipe.domain.Ingredient;
import guru.springframework.recipe.domain.Recipe;
import guru.springframework.recipe.repositories.RecipeRepository;

/**
 * Created by tairovich_jr on Sep 25, 2020
 */
public class IngredientServiceImplTest {

	
	private final IngredientToIngredientCommand ingredientToIngredientCommand;
	
	@Mock
	RecipeRepository recipeRepository;
	
	IngredientService ingredientService;
	
	//init converters
	public IngredientServiceImplTest() {
		this.ingredientToIngredientCommand = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
	}
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		ingredientService = new IngredientServiceImpl(ingredientToIngredientCommand, recipeRepository);
	}
	
	@Test
	public void findByRecipeIdAndIngredientId() {
		
	}
	
	@Test
	public void findByRecipeIdAndIngredientIdHappyPath() {
		
		//Given
		Recipe recipe = new Recipe();
		recipe.setId(1L);
		
		Ingredient ingredient1 = new Ingredient();
		ingredient1.setId(1L);
		
		Ingredient ingredient2 = new Ingredient();
		ingredient2.setId(2L);
		
		Ingredient ingredient3 = new Ingredient();
		ingredient3.setId(3L);
		
		recipe.addIngredient(ingredient1);
		recipe.addIngredient(ingredient2);
		recipe.addIngredient(ingredient3);
		
		Optional<Recipe> recipeOptional = Optional.of(recipe);
		
		when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);
	
		//when
		IngredientCommand ingredientCommand = ingredientService.findByRecipeIdAndIngredientId(1L, 3L);
		
		//when
		assertEquals(Long.valueOf(3L), ingredientCommand.getId());
		assertEquals(Long.valueOf(1L), ingredientCommand.getRecipeId());
		
		verify(recipeRepository, times(1)).findById(anyLong());
	}
	
	
	
	
	
	
	
	
	
	
	
}

