package guru.springframework.recipe.services;

import java.util.Set;

import guru.springframework.recipe.domain.Recipe;

public interface RecipeService {

	
	public Set<Recipe> getRecipes();
	
}
