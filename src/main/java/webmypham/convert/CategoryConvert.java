package webmypham.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import webmypham.DTO.CategoryDTO;
import webmypham.DTO.TitleCategoryDTO;
import webmypham.DTO.TrademarkDTO;
import webmypham.model.Category;
import webmypham.model.CategoryTitle;
import webmypham.model.Trademark;
import webmypham.service.CategoryService;
import webmypham.service.CatogorytitleService;

@Component
public class CategoryConvert {

	@Autowired
	CatogorytitleService cateCatogorytitleService;
	@Autowired
	TitleCategoryConvert titleCategoryConvert;
	
	public CategoryDTO mapCategoryEntityToDto(Category category) {
		CategoryDTO categorydto = new CategoryDTO();
		categorydto.setId(category.getId());
		categorydto.setNamecategory(category.getNamecategory());
		categorydto.setTitlecategory(category.getIdtitlecategory().getTitle());
		return categorydto;
	}
	
	public Category mapCategoryDtoToEntity(CategoryDTO categoryDTO) {
		TitleCategoryDTO title = cateCatogorytitleService.getTitle(categoryDTO.getTitlecategory());
		Category category = new Category();
		category.setId(categoryDTO.getId());
		category.setNamecategory(categoryDTO.getNamecategory());
		category.setIdtitlecategory(titleCategoryConvert.mapTitleCategoryDtoToEntity(title));
		return category;
	}
	
//	public CategoryDTO mapCategoryEntityToDto2(Category category) {
//		CategoryDTO categorydto = new CategoryDTO();
//		categorydto.setId(category.getId());
//		categorydto.setNamecategory(category.getNamecategory());
//		categorydto.setTitlecategory(category.getIdtitlecategory().getTitle());
//		return categorydto;
//	}
}
