package webmypham.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webmypham.DTO.CategoryDTO;
import webmypham.DTO.TitleCategoryDTO;
import webmypham.convert.CategoryConvert;
import webmypham.convert.TitleCategoryClassDTO;
import webmypham.convert.TitleCategoryConvert;
import webmypham.model.Category;
import webmypham.model.CategoryTitle;
import webmypham.repository.CategoryRipository;
import webmypham.repository.CategoryTitlieRepository;
@Service
public class CatogorytitleService {

	@Autowired
	CategoryTitlieRepository categoryTitlieRepository;
	
	@Autowired
	CategoryRipository categoryRipository;
	@Autowired
	CategoryConvert categoryConvert;
	@Autowired
	TitleCategoryConvert titleCategoryConvert;
	@Autowired
	CategoryService categoryservice;
	
	
	
	public CategoryTitle findOne(int id) {
		return categoryTitlieRepository.findOne(id);
	}
	
	
	
	public TitleCategoryDTO getTitle(String title) {
		return titleCategoryConvert.mapTitleCategoryEntityToDto(categoryTitlieRepository.findByCategoryTitle(title),categoryservice.getCategory(categoryTitlieRepository.findByCategoryTitle(title).getId()));
	}
	
	public CategoryTitle getidTitle(int id) {
		return categoryTitlieRepository.findByidCategoryTitle(id);
	}
	
	public List<TitleCategoryDTO> getAll(){
		List<TitleCategoryDTO> tit = new ArrayList<TitleCategoryDTO>();
		for (CategoryTitle item : categoryTitlieRepository.findAll()) {
			List<CategoryDTO> listcatedto = new ArrayList<CategoryDTO>();
			for (Category cate : categoryRipository.getCategory(item.getId())) {
				listcatedto.add(categoryConvert.mapCategoryEntityToDto(cate));
			}
			tit.add(titleCategoryConvert.mapTitleCategoryEntityToDto(item, listcatedto));
		}
		return tit;
	}
	
	
	
}
