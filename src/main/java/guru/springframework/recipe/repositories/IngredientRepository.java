package guru.springframework.recipe.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.recipe.domain.Ingredient;

/**
 * Created by tairovich_jr on Sep 28, 2020
 */
public interface IngredientRepository extends CrudRepository<Ingredient, Long>{

}
