package guru.springframework.recipe.commands;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by tairovich_jr on Sep 24, 2020
 */
@Getter
@Setter
@NoArgsConstructor
public class IngredientCommand {
  
	private Long id;
	private Long recipeId;
    private String description;
    private BigDecimal amount;
    private UnitOfMeasureCommand unitOfMeasure;

}