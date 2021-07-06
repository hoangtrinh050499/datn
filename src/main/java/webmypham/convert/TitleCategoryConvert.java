package webmypham.convert;

import java.util.List;

import org.springframework.stereotype.Component;

import webmypham.DTO.CategoryDTO;
import webmypham.DTO.TitleCategoryDTO;
import webmypham.model.Category;
import webmypham.model.CategoryTitle;

@Component
public class TitleCategoryConvert {
	
	public TitleCategoryDTO mapTitleCategoryEntityToDto(CategoryTitle catetitle , List<CategoryDTO> cate) {
		TitleCategoryDTO catedto =  new TitleCategoryDTO();
		catedto.setId(catetitle.getId());
		catedto.setTitle(catetitle.getTitle());
		catedto.setCategory(cate);
		return catedto;
	}
	
	public CategoryTitle mapTitleCategoryDtoToEntity(TitleCategoryDTO catetitle) {
		CategoryTitle catedto =  new CategoryTitle();
		catedto.setId(catetitle.getId());
		catedto.setTitle(catetitle.getTitle());
		return catedto;
	}
	
	
	public TitleCategoryClassDTO mapTitleCategoryEntityToDto(CategoryTitle catetitle) {
		TitleCategoryClassDTO catedto =  new TitleCategoryClassDTO();
		catedto.setId(catetitle.getId());
		catedto.setTitle(catetitle.getTitle());
		return catedto;
	}
	
	

}
