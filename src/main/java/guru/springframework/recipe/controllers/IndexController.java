package guru.springframework.recipe.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import guru.springframework.recipe.repositories.RecipeRepository;
import guru.springframework.recipe.services.RecipeService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {

	private RecipeService recipeService;
	
	public IndexController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@RequestMapping({ "", "/", "/index","/index.html" })
	public String getIndexPage(Model model) {
		log.debug("Getting index page");
		model.addAttribute("recipes", recipeService.getRecipes());
		return "index";
	}

}
