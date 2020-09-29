package guru.springframework.recipe.services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import guru.springframework.recipe.domain.Recipe;
import guru.springframework.recipe.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by tairovich_jr on Sep 28, 2020
 */
@Slf4j
@Service
public class ImageServiceImpl implements ImageService{

	private final RecipeRepository recipeRepository;
	
	public ImageServiceImpl(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}

	@Override
	@Transactional
	public void saveImageFile(Long recipeId, MultipartFile file) {
		
		try {
			Recipe recipe = recipeRepository.findById(recipeId).get();
			Byte[] byteObjects = new Byte[file.getBytes().length];
			int i = 0;
			
			for (Byte b : file.getBytes()) {
				byteObjects[i++] = b;
			}
			
			recipe.setImage(byteObjects);
			recipeRepository.save(recipe);
			
		} catch (Exception e) {
			//TODO handle better
			log.error("Error Occurred ", e);
			e.printStackTrace();
		}
		
		
	}

}










