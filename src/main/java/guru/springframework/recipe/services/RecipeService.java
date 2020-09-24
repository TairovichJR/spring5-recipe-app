package guru.springframework.recipe.services;

import java.util.Set;

import guru.springframework.recipe.commands.RecipeCommand;
import guru.springframework.recipe.domain.Recipe;

public interface RecipeService {

	public Set<Recipe> getRecipes();
	
	public Recipe findById(Long id);
	
	public RecipeCommand saveRecipeCommand (RecipeCommand recipeCommand);
}
