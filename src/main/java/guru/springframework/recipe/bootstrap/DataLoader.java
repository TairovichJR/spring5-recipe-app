package guru.springframework.recipe.bootstrap;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.recipe.domain.Category;
import guru.springframework.recipe.domain.Difficulty;
import guru.springframework.recipe.domain.Ingredient;
import guru.springframework.recipe.domain.Notes;
import guru.springframework.recipe.domain.Recipe;
import guru.springframework.recipe.domain.UnitOfMeasure;
import guru.springframework.recipe.repositories.CategoryRepository;
import guru.springframework.recipe.repositories.RecipeRepository;
import guru.springframework.recipe.repositories.UnitOfMeasureRepository;

@Component
public class DataLoader implements CommandLineRunner{

	
	private RecipeRepository recipeRepository;
	private CategoryRepository categoryRepository;
	private UnitOfMeasureRepository unitOfMeasureRepository;
	

	public DataLoader(RecipeRepository recipeRepository, CategoryRepository categoryRepository,
			UnitOfMeasureRepository unitOfMeasureRepository) {
		this.recipeRepository = recipeRepository;
		this.categoryRepository = categoryRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
	}




	@Override
	public void run(String... args) throws Exception {
		
		
		/* Guacomola Recipe starts here*/
		Recipe perfectGuacamole = new Recipe();
		
		perfectGuacamole.setDescription("Strawberry Guacamole Recipe");
		perfectGuacamole.setPrepTime(10);
		perfectGuacamole.setCookTime(20);
		perfectGuacamole.setServings(2);
		perfectGuacamole.setSource("Simply Recipes");
		perfectGuacamole.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
		perfectGuacamole.setDirections("Grip the avocado gently on one side with one hand. With a large, sharp knife in the other hand, cut the avocado lengthwise around the seed. Open the two halves to expose the pit.");
		
		/*  Ingredients for Strawberry Guacamole Recipe*/
		Ingredient avacado = new Ingredient();
		avacado.setDescription("Avacado");
		avacado.setAmount( new BigDecimal(2));
		avacado.setRecipe(perfectGuacamole);
		
		Ingredient salt = new Ingredient();
		salt.setDescription("Salt");
		salt.setAmount( new BigDecimal(0.5));
		UnitOfMeasure teaspoon = unitOfMeasureRepository.findByDescription("Teaspoon").get();
		salt.setUnitOfMeasure(teaspoon);
		salt.setRecipe(perfectGuacamole);
		
		Ingredient lemoJuice = new Ingredient();
		lemoJuice.setDescription("Lemon Juice");
		lemoJuice.setAmount( new BigDecimal(1));
		UnitOfMeasure cup = unitOfMeasureRepository.findByDescription("Tablespoon").get();
		lemoJuice.setUnitOfMeasure(cup);
		lemoJuice.setRecipe(perfectGuacamole);
		
		Ingredient mincedRedOnion = new Ingredient();
		mincedRedOnion.setDescription("Mincred Red Onion");
		mincedRedOnion.setAmount(new BigDecimal(0.25));
		mincedRedOnion.setUnitOfMeasure(cup);
		mincedRedOnion.setRecipe(perfectGuacamole);
		
		
		
		/*  Ingredients for Strawberry Guacamole Recipe*/
		
		
		Set<Ingredient> ingredients = new HashSet<>();
		ingredients.add(avacado);
		ingredients.add(salt);
		ingredients.add(lemoJuice);
		ingredients.add(mincedRedOnion);
		
		perfectGuacamole.setIngredients(ingredients);
		perfectGuacamole.setDifficulty(Difficulty.EASY);
		
		/*  Notes  */
		Notes avacodaNotes = new Notes();
		avacodaNotes.setRecipeNotes("Be Careful! Dont dont cut your finger");
		avacodaNotes.setRecipe(perfectGuacamole);
		
		perfectGuacamole.setNotes(avacodaNotes);
		
		/*  So far there is one recipe in the list of recipes*/
		Set<Recipe> recipes = new HashSet<>();
		recipes.add(perfectGuacamole);
		
		Category americanCategory = categoryRepository.findByDescription("American").get();
		
		americanCategory.setRecipes(recipes);
		
		Set<Category> allCategories = new HashSet<>();
		allCategories.add(americanCategory);
		
		perfectGuacamole.setCategories(allCategories);
		
		
		recipeRepository.save(perfectGuacamole);
	}

	
	
	
}
