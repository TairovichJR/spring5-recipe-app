package guru.springframework.recipe.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import guru.springframework.recipe.repositories.RecipeRepository;

@Controller
public class IndexController {

	private RecipeRepository recipeRepository;
	
	public IndexController(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}

	@RequestMapping({ "", "/", "/index" })
	public String getIndexPage(Model model) {

		model.addAttribute("recipes", recipeRepository.findAll());
		return "index";
	}

	
	

}
