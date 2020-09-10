package guru.springframework.recipe.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.recipe.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{

}
