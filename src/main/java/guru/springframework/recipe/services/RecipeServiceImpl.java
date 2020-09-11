package guru.springframework.recipe.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import guru.springframework.recipe.domain.Recipe;
import guru.springframework.recipe.repositories.RecipeRepository;

@Service
public class RecipeServiceImpl implements RecipeService{

	
	@Autowired
	private RecipeRepository recipeRepository;
	
	
	@Override
	public Set<Recipe> getRecipes() {
		
		Set<Recipe> recipes = (Set<Recipe>)recipeRepository.findAll();
		return recipes;
	}

	
	
}
