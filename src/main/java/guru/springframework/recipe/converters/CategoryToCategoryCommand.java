package guru.springframework.recipe.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import guru.springframework.recipe.commands.CategoryCommand;
import guru.springframework.recipe.domain.Category;
import lombok.Synchronized;

/**
 * Created by tairovich_jr on Sep 24, 2020
 */
@Component
public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand> {

    @Synchronized
    @Nullable
    @Override
    public CategoryCommand convert(Category source) {
        if (source == null) {
            return null;
        }

        final CategoryCommand categoryCommand = new CategoryCommand();

        categoryCommand.setId(source.getId());
        categoryCommand.setDescription(source.getDescription());

        return categoryCommand;
    }
}
