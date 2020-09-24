package guru.springframework.recipe.converters;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import org.springframework.lang.Nullable;

import guru.springframework.recipe.commands.CategoryCommand;
import guru.springframework.recipe.domain.Category;
import lombok.Synchronized;

/**
 * Created by tairovich_jr on Sep 24, 2020
 */
@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category>{

	@Synchronized
	@Nullable
	@Override
	public Category convert(CategoryCommand source) {
	
		if(source == null) {
			return null;
		}
		
		final Category category = new Category();
		category.setId(source.getId());
		category.setDescription(source.getDescription());
		return category;
	}
}