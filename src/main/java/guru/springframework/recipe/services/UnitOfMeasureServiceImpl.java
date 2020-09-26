package guru.springframework.recipe.services;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import guru.springframework.recipe.commands.UnitOfMeasureCommand;
import guru.springframework.recipe.converters.UnitOfMeasureToUnitOfMeasureCommand;
import guru.springframework.recipe.repositories.UnitOfMeasureRepository;

/**
 * Created by tairovich_jr on Sep 26, 2020
 */
@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

	private final UnitOfMeasureRepository unitOfMeasureRepository;
	private final UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

	public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository,
			UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand) {

		this.unitOfMeasureRepository = unitOfMeasureRepository;
		this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
	}

	@Override
	public Set<UnitOfMeasureCommand> listAllUnitOfMeasures() {
//		Set<UnitOfMeasureCommand> sets = new HashSet<>();
//		Iterator<UnitOfMeasure> it = unitOfMeasureRepository.findAll().iterator();
//		while(it.hasNext()) {
//			 UnitOfMeasure unitOfMeasure = it.next();
//			 UnitOfMeasureCommand command = unitOfMeasureToUnitOfMeasureCommand.convert(unitOfMeasure);
//			 sets.add(command);
//		}
//		return sets;
		return StreamSupport.stream(unitOfMeasureRepository.findAll()
								.spliterator(), false)
								.map(unitOfMeasureToUnitOfMeasureCommand::convert)
								.collect(Collectors.toSet());

	}

}
