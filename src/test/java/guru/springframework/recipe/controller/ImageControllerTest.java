package guru.springframework.recipe.controller;
/**
 * Created by tairovich_jr on Sep 28, 2020
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import guru.springframework.recipe.commands.RecipeCommand;
import guru.springframework.recipe.controllers.ControllerExceptionHandler;
import guru.springframework.recipe.controllers.ImageController;
import guru.springframework.recipe.services.ImageService;
import guru.springframework.recipe.services.RecipeService;

public class ImageControllerTest {

	@Mock
	ImageService imageService;
	
	@Mock
	RecipeService recipeService;

	ImageController controller;
	
	MockMvc mockMvc;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		controller = new ImageController(imageService, recipeService);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).setControllerAdvice(new ControllerExceptionHandler()).build();
	}
	
	@Test
	public void getImageForm() throws Exception {
		RecipeCommand command = new RecipeCommand();
		command.setId(1L);
		
		when(recipeService.findCommandById(anyLong())).thenReturn(command);
		
		//when
		mockMvc.perform(get("/recipe/1/image"))
					.andExpect(status().isOk())
					.andExpect(model().attributeExists("recipe"));
		
		verify(recipeService, times(1)).findCommandById(anyLong());
	}
	
	@Test
	public void handleImagePost() throws Exception {
		MockMultipartFile mockMultipartFile =
					new MockMultipartFile("imagefile", "testing.txt", "text/plain", "Spring Framework Guru".getBytes());
		mockMvc.perform(multipart("/recipe/1/image").file(mockMultipartFile))
					.andExpect(status().is3xxRedirection())
					.andExpect(header().string("Location", "/recipe/1/show"));
		verify(imageService, times(1)).saveImageFile(anyLong(), any());
	}
	
	
	@Test
	public void renderImageFromDB() throws Exception {
		
		RecipeCommand command = new RecipeCommand();
		command.setId(1L);
		
		String s = "fake image text";
		Byte[] bytesBoxed = new Byte[s.getBytes().length];
		
		int i = 0;
		for(byte primByte : s.getBytes()) {
			bytesBoxed[i++] = primByte;
		}
		
		command.setImage(bytesBoxed);
		
		when(recipeService.findCommandById(anyLong())).thenReturn(command);
		
		//when
		MockHttpServletResponse response = mockMvc.perform(get("/recipe/1/recipeimage"))
						.andExpect(status().isOk())
						.andReturn().getResponse();
		
		byte[] responseBytes = response.getContentAsByteArray();
		assertEquals(s.getBytes().length, responseBytes.length);
		
	}
	
	
	@Test
	public void testGetImageNumberFormatException() throws Exception {
		mockMvc.perform(get("/recipe/df/recipeimage"))
				.andExpect(status().isBadRequest())
				.andExpect(view().name("400error"));
		
	}
	
}
