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

	
	}
	
	
	
	
	
	
	
	
}
