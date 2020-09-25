package guru.springframework.recipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import guru.springframework.recipe.commands.RecipeCommand;
import guru.springframework.recipe.services.RecipeService;

/**
 * Created by tairovich_jr on Sep 23, 2020
 */
@Controller
public class RecipeController {

	private final RecipeService recipeService;
	
	public RecipeController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@RequestMapping("/recipe/show/{id}")
	public String getRecipeById(@PathVariable String id, Model model) {
		
		model.addAttribute("recipe", recipeService.findById(Long.parseLong(id)));
		return "/recipe/show";
	}
	
	
	@RequestMapping("/recipe/new")
	public String getNewRecipe(Model model) {
		
		model.addAttribute("recipe", new RecipeCommand());
		
		return "recipe/recipeform";
	}
	
	
	@PostMapping
	@RequestMapping("recipe")
	public String saveOrUpdateRecipe(@ModelAttribute RecipeCommand recipeCommand) {
		
		RecipeCommand savedCommand = recipeService.saveRecipeCommand(recipeCommand);
		
		return "redirect:/recipe/show/" + savedCommand.getId(); 
	}
	
	
	
}
