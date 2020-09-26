package guru.springframework.recipe.services;
/**
 * Created by tairovich_jr on Sep 25, 2020
 */

import guru.springframework.recipe.commands.IngredientCommand;

public interface IngredientService {

	
	public IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);
}
