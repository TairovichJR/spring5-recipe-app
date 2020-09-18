package guru.springframework.recipe.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created by tairovich_jr on Sep 15, 2020
 */
public class CategoryTest {

	Category category;
	
	@BeforeEach
	public void setUp() {
		category = new Category();
	}
	
	@Test
	public void getId() throws Exception{
		
		Long idValue = 4L;
		category.setId(idValue);
		assertEquals(idValue, category.getId());
	}
	
	@Test
	public void getDescription() throws Exception{
		String description = "Mexican Category";
		category.setDescription(description);
		assertEquals(description, category.getDescription());
	}
	
	@Test
	public void getRecipes() throws Exception{
//		Set<Recipe> recipes = new HashSet<>();
//		Recipe recipe1 = new Recipe();
//		recipe1.setUrl("http://www.recipes.com");
//		recipe1.setSource("Cool Recipes");
//		recipe1.setServings(2);
//		recipe1.setPrepTime(1);
//		Notes recipe1Notes = new Notes();
//		recipe1Notes.setRecipeNotes("My Notes");
//		recipe1Notes.setRecipe(recipe1);
//		recipe1.setNotes(recipe1Notes);
//		
//		UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
//		unitOfMeasure.setDescription("spoon");
//		
//		recipe1.addIngredient(new Ingredient("ripe avocados", new BigDecimal(2), unitOfMeasure));
//		recipe1.addIngredient(new Ingredient("Kosher salt", new BigDecimal(".5"), unitOfMeasure));
//		recipe1.addIngredient(new Ingredient("fresh lime juice or lemon juice", new BigDecimal(2), unitOfMeasure));
//		recipe1.addIngredient(new Ingredient("minced red onion or thinly sliced green onion", new BigDecimal(2), unitOfMeasure));
//		recipe1.addIngredient(new Ingredient("serrano chiles, stems and seeds removed, minced", new BigDecimal(2), unitOfMeasure));
//		
//		Category category1 = new Category();
//		category1.setDescription("American");
//		category1.setRecipes(recipes);
//		
//		recipe1.getCategories().add(category1);
//		recipe1.setDifficulty(Difficulty.EASY);
//		recipe1.setDescription("Recipe 1 description");
//		recipe1.setDirections("Recipe 1 directions");
//		recipe1.setCookTime(1);
//		
//		
//		assertEquals(recipe1, category.getRecipes());
		
		
	}
	
	
	
	
	
	
	
	
}
