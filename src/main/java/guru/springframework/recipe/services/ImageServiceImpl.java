package guru.springframework.recipe.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by tairovich_jr on Sep 28, 2020
 */
@Slf4j
@Service
public class ImageServiceImpl implements ImageService{

	
	
	@Override
	public void saveImageFile(Long recipeId, MultipartFile file) {
		
		log.debug("Recieved a file");
	}

}
