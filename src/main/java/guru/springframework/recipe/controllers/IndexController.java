package guru.springframework.recipe.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.recipe.domain.Category;
import guru.springframework.recipe.domain.UnitOfMeasure;
import guru.springframework.recipe.repositories.CategoryRepository;
import guru.springframework.recipe.repositories.RecipeRepository;
import guru.springframework.recipe.repositories.UnitOfMeasureRepository;

@Controller
public class IndexController {

	private CategoryRepository categoryRepository;
	private UnitOfMeasureRepository unitOfMeasureRepository;
	private RecipeRepository recipeRepository;
	
	public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository,
			RecipeRepository recipeRepository) {
		this.categoryRepository = categoryRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
		this.recipeRepository = recipeRepository;
	}

	@RequestMapping({ "", "/", "/index" })
	public String getIndexPage() {

		Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
		Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

		System.out.println("Cat Id is: " + categoryOptional.get().getId());
		System.out.println("UOM Id is: " + unitOfMeasureOptional.get().getId());
		return "index";
	}
	
	@RequestMapping({"/recipes"})
	public String getRecipes(Model model) {
		
		model.addAttribute("recipes", recipeRepository.findAll());
		
		return "recipe";
	}
	
	

}
