package guru.springframework.recipe.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by tairovich_jr on Sep 24, 2020
 */
@Setter
@Getter
@NoArgsConstructor
public class CategoryCommand {

	private Long id;
	private String description;
	
}
