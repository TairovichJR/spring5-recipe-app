package guru.springframework.recipe.services;
/**
 * Created by tairovich_jr on Sep 26, 2020
 */

import java.util.Set;

import guru.springframework.recipe.commands.UnitOfMeasureCommand;

public interface UnitOfMeasureService {

	Set<UnitOfMeasureCommand> listAllUnitOfMeasures();
	
}
