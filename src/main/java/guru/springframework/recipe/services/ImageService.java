package guru.springframework.recipe.services;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by tairovich_jr on Sep 28, 2020
 */
public interface ImageService {

	public void saveImageFile(Long recipeId, MultipartFile file);
}
